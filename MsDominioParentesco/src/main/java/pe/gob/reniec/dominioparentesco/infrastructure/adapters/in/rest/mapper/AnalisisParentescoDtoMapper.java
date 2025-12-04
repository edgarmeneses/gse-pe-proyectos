package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.dominioparentesco.domain.model.*;
import pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre DTOs y objetos del dominio rico.
 */
public class AnalisisParentescoDtoMapper {
    
    /**
     * Convierte un DTO de request a objetos del dominio.
     */
    public DNI extractDNI(EjecutarAnalisisRequestDto dto) {
        return DNI.of(dto.getIdCiudadanoConsultado());
    }
    
    public TipoVinculo extractTipoVinculo(EjecutarAnalisisRequestDto dto) {
        return TipoVinculo.fromCodigo(dto.getCodTipoVinculo());
    }
    
    public int extractProfundidad(EjecutarAnalisisRequestDto dto) {
        return dto.getNivelComplejidad() != null ? dto.getNivelComplejidad() : 2;
    }
    
    public String extractUsuario(EjecutarAnalisisRequestDto dto) {
        return dto.getUsuarioTecnico();
    }
    
    /**
     * Convierte un AnalisisParentesco (modelo rico) a DTO de response.
     */
    public EjecutarAnalisisResponseDto toDto(AnalisisParentesco analisis, String correlationId) {
        EjecutarAnalisisDataDto data = new EjecutarAnalisisDataDto();
        data.setIdSolicitud(analisis.getIdAnalisis());
        data.setIdCiudadanoConsultado(analisis.getCiudadanoAnalizado().getDni().valor());
        data.setCodTipoVinculo(analisis.getTipoVinculoBuscado().getCodigo());
        data.setNivelComplejidad(analisis.getProfundidadAnalisis());
        data.setEstadoSolicitud(analisis.getEstado().name());
        data.setCiudadanoAnalizado(mapCiudadanoAnalizado(analisis.getCiudadanoAnalizado()));
        data.setPoblacionVinculosPosibles(mapPoblacionVinculos(analisis));
        data.setResumenAnalisis(mapResumenAnalisis(analisis.calcularEstadisticas()));
        data.setInconsistencias(mapInconsistencias(analisis.getInconsistencias()));
        data.setActasPendientesDigitalizacion(new ArrayList<>());
        data.setFechaSolicitud(analisis.getFechaInicio());
        data.setTiempoProcesamientoMs(analisis.calcularTiempoProcesamiento());
        data.setUsuarioTecnico(analisis.getUsuarioSolicitante());
        
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now());
        metadata.setCorrelationId(correlationId);
        metadata.setVersion("1.0");
        
        ServiciosConsultadosDto servicios = new ServiciosConsultadosDto();
        servicios.setMsSagaAPD(true);
        servicios.setMsDatosActas(true);
        servicios.setMsDatosParentesco(true);
        metadata.setServiciosConsultados(servicios);
        
        EjecutarAnalisisResponseDto response = new EjecutarAnalisisResponseDto();
        response.setSuccess(true);
        response.setData(data);
        response.setMetadata(metadata);
        
        return response;
    }
    
    private CiudadanoAnalizadoDto mapCiudadanoAnalizado(Ciudadano ciudadano) {
        CiudadanoAnalizadoDto dto = new CiudadanoAnalizadoDto();
        dto.setIdCiudadano(ciudadano.getDni().valor());
        dto.setNombre(ciudadano.getNombreCompleto());
        dto.setFechaNacimiento(ciudadano.getFechaNacimiento());
        
        DatosAPDDto apdDto = new DatosAPDDto();
        apdDto.setVersion("1.0");
        apdDto.setUltimaActualizacion(LocalDateTime.now());
        apdDto.setEstadoAPD("VIGENTE");
        dto.setDatosAPD(apdDto);
        
        return dto;
    }
    
    private PoblacionVinculosPosiblesDto mapPoblacionVinculos(AnalisisParentesco analisis) {
        List<VinculoConsanguineoDto> consanguineos = analisis.getVinculosEncontrados().stream()
            .filter(v -> v.getTipo().esConsanguineo())
            .map(this::mapVinculoConsanguineo)
            .collect(Collectors.toList());
        
        List<VinculoAfinidadDto> afinidad = analisis.getVinculosEncontrados().stream()
            .filter(v -> v.getTipo().esAfinidad())
            .map(this::mapVinculoAfinidad)
            .collect(Collectors.toList());
        
        PoblacionVinculosPosiblesDto dto = new PoblacionVinculosPosiblesDto();
        dto.setTotalEncontrados(analisis.getVinculosEncontrados().size());
        dto.setVinculosConsanguineos(consanguineos);
        dto.setVinculosAfinidad(afinidad);
        
        return dto;
    }
    
    private VinculoConsanguineoDto mapVinculoConsanguineo(Vinculo vinculo) {
        VinculoConsanguineoDto dto = new VinculoConsanguineoDto();
        dto.setIdRelacion(null);
        dto.setIdCiudadanoOrigen(vinculo.getOrigen().getDni().valor());
        dto.setIdCiudadanoDestino(vinculo.getDestino().getDni().valor());
        dto.setNombreCiudadanoDestino(vinculo.getDestino().getNombreCompleto());
        dto.setCodTipo(vinculo.getTipo().getCodigo());
        dto.setDescripcionTipo(vinculo.getTipo().getDescripcion());
        dto.setCategoria(vinculo.getTipo().getCategoria().name());
        dto.setGradoMinimo(vinculo.getTipo().getGrado());
        dto.setEsSimetrico("N");
        dto.setCodInverso(null);
        dto.setFechaInicio(null);
        dto.setFechaFin(null);
        dto.setIdActaSustento(null);
        dto.setActaSustento(null);
        dto.setIdDocumentoSustento(null);
        dto.setNivelConfianza(vinculo.getNivelConfianza().getRangoMinimo());
        dto.setEstadoConfirmacion(vinculo.isActaValidada() ? "CONFIRMADO" : "PENDIENTE");
        dto.setRequiereValidacionManual(vinculo.requiereValidacionManual());
        dto.setObservacion(null);
        
        return dto;
    }
    
    private VinculoAfinidadDto mapVinculoAfinidad(Vinculo vinculo) {
        VinculoAfinidadDto dto = new VinculoAfinidadDto();
        dto.setIdRelacion(null);
        dto.setIdCiudadanoOrigen(vinculo.getOrigen().getDni().valor());
        dto.setIdCiudadanoDestino(vinculo.getDestino().getDni().valor());
        dto.setNombreCiudadanoDestino(vinculo.getDestino().getNombreCompleto());
        dto.setCodTipo(vinculo.getTipo().getCodigo());
        dto.setDescripcionTipo(vinculo.getTipo().getDescripcion());
        dto.setCategoria(vinculo.getTipo().getCategoria().name());
        dto.setGradoMinimo(vinculo.getTipo().getGrado());
        dto.setEsSimetrico("N");
        dto.setCodInverso(null);
        dto.setConyugeIntermedio(null);
        dto.setFechaInicio(null);
        dto.setFechaFin(null);
        dto.setIdActaSustento(null);
        dto.setActaSustento(null);
        dto.setIdDocumentoSustento(null);
        dto.setNivelConfianza(vinculo.getNivelConfianza().getRangoMinimo());
        dto.setEstadoConfirmacion(vinculo.isActaValidada() ? "CONFIRMADO" : "PENDIENTE");
        dto.setRequiereValidacionManual(vinculo.requiereValidacionManual());
        dto.setObservacion(null);
        
        return dto;
    }
    
    private ResumenAnalisisDto mapResumenAnalisis(EstadisticasAnalisis stats) {
        ResumenAnalisisDto dto = new ResumenAnalisisDto();
        dto.setVinculosGrado1(stats.getVinculosPrimerGrado());
        dto.setVinculosGrado2(stats.getVinculosSegundoGrado());
        dto.setVinculosGrado3(stats.getVinculosTercerGrado());
        dto.setVinculosGrado4(stats.getVinculosCuartoGrado());
        dto.setVinculosAfinidad(0);
        dto.setActasConsultadas(stats.getTotalVinculosEncontrados());
        dto.setActasNoDigitalizadas(0);
        dto.setInconsistenciasDetectadas(stats.getInconsistenciasDetectadas());
        
        return dto;
    }
    
    private List<InconsistenciaDto> mapInconsistencias(List<DeteccionInconsistencia> inconsistencias) {
        return inconsistencias.stream()
            .map(i -> {
                InconsistenciaDto dto = new InconsistenciaDto();
                dto.setTipo(i.getTipo().name());
                dto.setDescripcion(i.getDescripcion());
                dto.setCiudadanosInvolucrados(
                    i.getCiudadanosAfectados().stream()
                        .map(c -> c.getDni().valor())
                        .collect(Collectors.toList())
                );
                dto.setSeveridad(i.getTipo().esCritica() ? "CRITICA" : "MEDIA");
                dto.setAccionRecomendada(i.getTipo().requiereRevision() ? "REVISION_MANUAL" : "INFORMATIVA");
                return dto;
            })
            .collect(Collectors.toList());
    }
}
