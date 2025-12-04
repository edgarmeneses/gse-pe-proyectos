package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.dominioparentesco.domain.model.*;
import pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre DTOs y objetos del dominio.
 */
public class AnalisisParentescoDtoMapper {
    
    /**
     * Convierte un DTO de request a un objeto del dominio.
     */
    public SolicitudAnalisisParentesco toDomain(EjecutarAnalisisRequestDto dto) {
        DatosCiudadano datosCiudadano = new DatosCiudadano(
            dto.datosCiudadano().nombre(),
            dto.datosCiudadano().fechaNacimiento()
        );
        
        CriteriosBusqueda criterios = dto.criteriosBusqueda() != null ?
            new CriteriosBusqueda(
                dto.criteriosBusqueda().rangoAniosPadres() != null ?
                    new RangoAnios(
                        dto.criteriosBusqueda().rangoAniosPadres().anioInicio(),
                        dto.criteriosBusqueda().rangoAniosPadres().anioFin()
                    ) : null,
                dto.criteriosBusqueda().rangoAniosHijos() != null ?
                    new RangoAnios(
                        dto.criteriosBusqueda().rangoAniosHijos().anioInicio(),
                        dto.criteriosBusqueda().rangoAniosHijos().anioFin()
                    ) : null,
                dto.criteriosBusqueda().variacionesNombre(),
                dto.criteriosBusqueda().incluirFallecidos(),
                dto.criteriosBusqueda().incluirActasAnuladas()
            ) : null;
        
        OpcionesAnalisis opciones = dto.opcionesAnalisis() != null ?
            new OpcionesAnalisis(
                dto.opcionesAnalisis().generarArbolGenealogico(),
                dto.opcionesAnalisis().validarContraAPD(),
                dto.opcionesAnalisis().incluirActasSustento(),
                dto.opcionesAnalisis().detectarInconsistencias()
            ) : null;
        
        return SolicitudAnalisisParentesco.builder()
            .idSolicitud(dto.idSolicitud())
            .idCiudadanoConsultado(dto.idCiudadanoConsultado())
            .datosCiudadano(datosCiudadano)
            .codTipoVinculo(dto.codTipoVinculo())
            .nivelComplejidad(dto.nivelComplejidad())
            .criteriosBusqueda(criterios)
            .opcionesAnalisis(opciones)
            .usuarioTecnico(dto.usuarioTecnico())
            .observaciones(dto.observaciones())
            .build();
    }
    
    /**
     * Convierte un objeto del dominio a DTO de response.
     */
    public EjecutarAnalisisResponseDto toDto(ResultadoAnalisisParentesco resultado, String correlationId) {
        EjecutarAnalisisDataDto data = new EjecutarAnalisisDataDto(
            resultado.getIdSolicitud(),
            resultado.getIdCiudadanoConsultado(),
            resultado.getCodTipoVinculo(),
            resultado.getNivelComplejidad(),
            resultado.getEstadoSolicitud(),
            mapCiudadanoAnalizado(resultado.getCiudadanoAnalizado()),
            mapPoblacionVinculos(resultado.getPoblacionVinculosPosibles()),
            mapResumenAnalisis(resultado.getResumenAnalisis()),
            mapInconsistencias(resultado.getInconsistencias()),
            mapActasPendientes(resultado.getActasPendientesDigitalizacion()),
            resultado.getFechaSolicitud(),
            resultado.getTiempoProcesamientoMs(),
            resultado.getUsuarioTecnico()
        );
        
        MetadataDto metadata = new MetadataDto(
            LocalDateTime.now(),
            correlationId,
            "1.0",
            new ServiciosConsultadosDto(true, true, true)
        );
        
        return new EjecutarAnalisisResponseDto(true, data, metadata);
    }
    
    private CiudadanoAnalizadoDto mapCiudadanoAnalizado(CiudadanoAnalizado ciudadano) {
        DatosAPDDto apdDto = ciudadano.getDatosAPD() != null ?
            new DatosAPDDto(
                ciudadano.getDatosAPD().getVersion(),
                ciudadano.getDatosAPD().getUltimaActualizacion(),
                ciudadano.getDatosAPD().getEstadoAPD()
            ) : null;
        
        return new CiudadanoAnalizadoDto(
            ciudadano.getIdCiudadano(),
            ciudadano.getNombre(),
            ciudadano.getFechaNacimiento(),
            apdDto
        );
    }
    
    private PoblacionVinculosPosiblesDto mapPoblacionVinculos(PoblacionVinculosPosibles poblacion) {
        List<VinculoConsanguineoDto> consanguineos = poblacion.getVinculosConsanguineos().stream()
            .map(this::mapVinculoConsanguineo)
            .collect(Collectors.toList());
        
        List<VinculoAfinidadDto> afinidad = poblacion.getVinculosAfinidad().stream()
            .map(this::mapVinculoAfinidad)
            .collect(Collectors.toList());
        
        return new PoblacionVinculosPosiblesDto(
            poblacion.getTotalEncontrados(),
            consanguineos,
            afinidad
        );
    }
    
    private VinculoConsanguineoDto mapVinculoConsanguineo(VinculoConsanguineo vinculo) {
        ActaSustentoDto actaDto = vinculo.getActaSustento() != null ?
            new ActaSustentoDto(
                vinculo.getActaSustento().getIdActa(),
                vinculo.getActaSustento().getTipoActa(),
                vinculo.getActaSustento().getFechaActa(),
                vinculo.getActaSustento().getLugarActa()
            ) : null;
        
        return new VinculoConsanguineoDto(
            vinculo.getIdRelacion(),
            vinculo.getIdCiudadanoOrigen(),
            vinculo.getIdCiudadanoDestino(),
            vinculo.getNombreCiudadanoDestino(),
            vinculo.getCodTipo(),
            vinculo.getDescripcionTipo(),
            vinculo.getCategoria(),
            vinculo.getGradoMinimo(),
            vinculo.getEsSimetrico(),
            vinculo.getCodInverso(),
            vinculo.getFechaInicio(),
            vinculo.getFechaFin(),
            vinculo.getIdActaSustento(),
            actaDto,
            vinculo.getIdDocumentoSustento(),
            vinculo.getNivelConfianza(),
            vinculo.getEstadoConfirmacion(),
            vinculo.getRequiereValidacionManual(),
            vinculo.getObservacion()
        );
    }
    
    private VinculoAfinidadDto mapVinculoAfinidad(VinculoAfinidad vinculo) {
        ConyugeIntermedioDto conyugeDto = vinculo.getConyugeIntermedio() != null ?
            new ConyugeIntermedioDto(
                vinculo.getConyugeIntermedio().getIdCiudadano(),
                vinculo.getConyugeIntermedio().getNombre()
            ) : null;
        
        ActaSustentoDto actaDto = vinculo.getActaSustento() != null ?
            new ActaSustentoDto(
                vinculo.getActaSustento().getIdActa(),
                vinculo.getActaSustento().getTipoActa(),
                vinculo.getActaSustento().getFechaActa(),
                vinculo.getActaSustento().getLugarActa()
            ) : null;
        
        return new VinculoAfinidadDto(
            vinculo.getIdRelacion(),
            vinculo.getIdCiudadanoOrigen(),
            vinculo.getIdCiudadanoDestino(),
            vinculo.getNombreCiudadanoDestino(),
            vinculo.getCodTipo(),
            vinculo.getDescripcionTipo(),
            vinculo.getCategoria(),
            vinculo.getGradoMinimo(),
            vinculo.getEsSimetrico(),
            vinculo.getCodInverso(),
            conyugeDto,
            vinculo.getFechaInicio(),
            vinculo.getFechaFin(),
            vinculo.getIdActaSustento(),
            actaDto,
            vinculo.getIdDocumentoSustento(),
            vinculo.getNivelConfianza(),
            vinculo.getEstadoConfirmacion(),
            vinculo.getRequiereValidacionManual(),
            vinculo.getObservacion()
        );
    }
    
    private ResumenAnalisisDto mapResumenAnalisis(ResumenAnalisis resumen) {
        return new ResumenAnalisisDto(
            resumen.getVinculosGrado1(),
            resumen.getVinculosGrado2(),
            resumen.getVinculosGrado3(),
            resumen.getVinculosGrado4(),
            resumen.getVinculosAfinidad(),
            resumen.getActasConsultadas(),
            resumen.getActasNoDigitalizadas(),
            resumen.getInconsistenciasDetectadas()
        );
    }
    
    private List<InconsistenciaDto> mapInconsistencias(List<Inconsistencia> inconsistencias) {
        return inconsistencias.stream()
            .map(i -> new InconsistenciaDto(
                i.getTipo(),
                i.getDescripcion(),
                i.getCiudadanosInvolucrados(),
                i.getSeveridad(),
                i.getAccionRecomendada()
            ))
            .collect(Collectors.toList());
    }
    
    private List<ActaPendienteDigitalizacionDto> mapActasPendientes(
            List<ActaPendienteDigitalizacion> actas) {
        return actas.stream()
            .map(a -> new ActaPendienteDigitalizacionDto(
                a.getTipoActa(),
                a.getReferenciaActa(),
                a.getLugarActa(),
                a.getObservacion()
            ))
            .collect(Collectors.toList());
    }
}
