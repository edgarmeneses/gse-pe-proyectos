package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.dominio.paquetes.domain.model.*;
import pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto.*;
import pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PaqueteElectoralDtoMapper {
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static LocalDateTime parseFecha(String fecha) {
        if (fecha == null) {
            return null;
        }
        return LocalDateTime.parse(fecha, ISO_FORMATTER);
    }

    public static ConsultarPaquetesResponseDto toConsultarPaquetesResponseDto(List<PaqueteElectoral> paquetes,
                                                                              Integer paginaActual, Integer registrosPorPagina) {
        ConsultarPaquetesResponseDto response = new ConsultarPaquetesResponseDto();
        response.setSuccess(true);
        
        ConsultarPaquetesResponseDto.DataConsultaDto data = new ConsultarPaquetesResponseDto.DataConsultaDto();
        data.setPaquetes(toPaqueteDtoList(paquetes));
        
        // Calcular resumen desde los paquetes
        ResumenPaquetes resumen = calcularResumen(paquetes);
        data.setResumen(toResumenPaquetesDto(resumen));
        
        // Calcular paginación
        InformacionPaginacion paginacion = calcularPaginacion(paquetes, paginaActual, registrosPorPagina);
        data.setPaginacion(toPaginacionDto(paginacion));
        
        response.setData(data);
        
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now().format(ISO_FORMATTER));
        metadata.setVersion("1.0");
        response.setMetadata(metadata);
        
        return response;
    }
    
    public static AprobarPaqueteResponseDto toAprobarPaqueteResponseDto(PaqueteElectoral paquete,
                                                                         InformacionPublicacionDto infoPublicacionDto) {
        AprobarPaqueteResponseDto response = new AprobarPaqueteResponseDto();
        response.setSuccess(true);
        
        ResultadoAprobacionPaquete resultado = new ResultadoAprobacionPaquete();
        resultado.setPaqueteId(paquete.getPaqueteId());
        resultado.setCodigoPaquete(paquete.getCodigoPaquete());
        resultado.setEstadoActual(paquete.getEstadoPaquete());
        resultado.setAprobacion(paquete.getAprobacion());
        
        if (infoPublicacionDto != null) {
            InformacionPublicacion infoPublicacion = new InformacionPublicacion();
            infoPublicacion.setFechaPublicacion(parseFecha(infoPublicacionDto.getFechaPublicacion()));
            infoPublicacion.setLugarPublicacion(infoPublicacionDto.getLugarPublicacion());
            infoPublicacion.setObservaciones(infoPublicacionDto.getObservaciones());
            resultado.setInformacionPublicacion(infoPublicacion);
        }
        
        InformacionTrazabilidad trazabilidad = new InformacionTrazabilidad();
        trazabilidad.setAccion("APROBACION_PAQUETE");
        trazabilidad.setFechaAccion(LocalDateTime.now());
        trazabilidad.setDetalleAccion("Paquete aprobado exitosamente");
        resultado.setTrazabilidad(trazabilidad);
        
        response.setData(resultado);
        
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now().format(ISO_FORMATTER));
        metadata.setVersion("1.0");
        response.setMetadata(metadata);
        
        return response;
    }
    
    public static ConfirmarRevisionResponseDto toConfirmarRevisionResponseDto(String idPadron, String tipoPadron) {
        ConfirmarRevisionResponseDto response = new ConfirmarRevisionResponseDto();
        response.setSuccess(true);
        
        ResultadoConfirmacionRevision resultado = new ResultadoConfirmacionRevision();
        resultado.setIdPadron(idPadron);
        resultado.setTipoPadron(tipoPadron);
        resultado.setEstadoRevisionActual("REVISION_CONFIRMADA");
        
        Confirmacion confirmacion = new Confirmacion();
        confirmacion.setConfirmado(true);
        confirmacion.setFechaConfirmacion(LocalDateTime.now());
        resultado.setConfirmacion(confirmacion);
        
        InformacionSiguientePaso siguientePaso = new InformacionSiguientePaso();
        siguientePaso.setAccion("GENERAR_OFICIO");
        siguientePaso.setDescripcion("Generar oficio de aprobación de paquetes electorales");
        siguientePaso.setPlantillaSugerida("PLANTILLA_OFICIO_APROBACION");
        resultado.setSiguientePaso(siguientePaso);
        
        InformacionTrazabilidad trazabilidad = new InformacionTrazabilidad();
        trazabilidad.setAccion("CONFIRMACION_REVISION");
        trazabilidad.setFechaAccion(LocalDateTime.now());
        trazabilidad.setDetalleAccion("Revisión de paquetes confirmada exitosamente");
        resultado.setTrazabilidad(trazabilidad);
        
        response.setData(resultado);
        
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now().format(ISO_FORMATTER));
        metadata.setVersion("1.0");
        response.setMetadata(metadata);
        
        return response;
    }
    
    private static ResumenPaquetes calcularResumen(List<PaqueteElectoral> paquetes) {
        ResumenPaquetes resumen = new ResumenPaquetes();
        resumen.setTotalPaquetes(paquetes.size());
        resumen.setPaquetesAprobados((int) paquetes.stream().filter(p -> "APROBADO".equals(p.getEstadoPaquete())).count());
        resumen.setPaquetesPendientes((int) paquetes.stream().filter(p -> "PENDIENTE".equals(p.getEstadoPaquete())).count());
        resumen.setPaquetesEnRevision((int) paquetes.stream().filter(p -> "EN_REVISION".equals(p.getEstadoPaquete())).count());
        
        if (resumen.getTotalPaquetes() > 0) {
            resumen.setPorcentajeAprobacion((double) resumen.getPaquetesAprobados() / resumen.getTotalPaquetes() * 100);
            resumen.setPorcentajeAvance((double) (resumen.getPaquetesAprobados() + resumen.getPaquetesEnRevision()) / resumen.getTotalPaquetes() * 100);
        }
        
        return resumen;
    }
    
    private static InformacionPaginacion calcularPaginacion(List<PaqueteElectoral> paquetes,
                                                            Integer paginaActual, Integer registrosPorPagina) {
        InformacionPaginacion paginacion = new InformacionPaginacion();
        paginacion.setTotalRegistros(paquetes.size());
        paginacion.setPaginaActual(paginaActual != null ? paginaActual : 1);
        paginacion.setRegistrosPorPagina(registrosPorPagina != null ? registrosPorPagina : 10);
        
        int totalPaginas = (int) Math.ceil((double) paquetes.size() / paginacion.getRegistrosPorPagina());
        paginacion.setTotalPaginas(totalPaginas);
        paginacion.setTieneAnterior(paginacion.getPaginaActual() > 1);
        paginacion.setTieneSiguiente(paginacion.getPaginaActual() < totalPaginas);
        
        return paginacion;
    }

    public static List<PaqueteElectoralDto> toPaqueteDtoList(List<PaqueteElectoral> paquetes) {
        if (paquetes == null) {
            return null;
        }
        return paquetes.stream()
                .map(PaqueteElectoralDtoMapper::toPaqueteElectoralDto)
                .collect(Collectors.toList());
    }

    public static PaqueteElectoralDto toPaqueteElectoralDto(PaqueteElectoral paquete) {
        if (paquete == null) {
            return null;
        }
        
        PaqueteElectoralDto dto = new PaqueteElectoralDto();
        dto.setPaqueteId(paquete.getPaqueteId());
        dto.setCodigoPaquete(paquete.getCodigoPaquete());
        dto.setIdPadron(paquete.getIdPadron());
        dto.setTipoPadron(paquete.getTipoPadron());
        dto.setCodigoCronogramaElectoral(paquete.getCodigoCronogramaElectoral());
        dto.setTipoProcesoElectoral(paquete.getTipoProcesoElectoral());
        dto.setUbicacion(toUbicacionDto(paquete.getUbicacion()));
        dto.setEstadoPaquete(paquete.getEstadoPaquete());
        dto.setFechaGeneracion(formatDateTime(paquete.getFechaGeneracion()));
        dto.setFechaUltimaActualizacion(formatDateTime(paquete.getFechaUltimaActualizacion()));
        dto.setUsuarioUltimaActualizacion(paquete.getUsuarioUltimaActualizacion());
        dto.setTotalCiudadanos(paquete.getTotalCiudadanos());
        dto.setTotalImagenes(paquete.getTotalImagenes());
        dto.setHashIntegridad(paquete.getHashIntegridad());
        dto.setAprobacion(toAprobacionDto(paquete.getAprobacion()));
        
        return dto;
    }

    public static UbicacionDto toUbicacionDto(Ubicacion ubicacion) {
        if (ubicacion == null) {
            return null;
        }
        
        UbicacionDto dto = new UbicacionDto();
        dto.setCodigoDepartamento(ubicacion.getCodigoDepartamento());
        dto.setNombreDepartamento(ubicacion.getNombreDepartamento());
        dto.setCodigoProvincia(ubicacion.getCodigoProvincia());
        dto.setNombreProvincia(ubicacion.getNombreProvincia());
        dto.setCodigoDistrito(ubicacion.getCodigoDistrito());
        dto.setNombreDistrito(ubicacion.getNombreDistrito());
        dto.setUbigeo(ubicacion.getUbigeo());
        
        return dto;
    }

    public static InformacionPublicacionDto toInformacionPublicacionDto(InformacionPublicacion info) {
        if (info == null) {
            return null;
        }
        
        InformacionPublicacionDto dto = new InformacionPublicacionDto();
        dto.setFechaPublicacion(formatDateTime(info.getFechaPublicacion()));
        dto.setLugarPublicacion(info.getLugarPublicacion());
        dto.setObservaciones(info.getObservaciones());
        
        return dto;
    }

    public static AprobacionDto toAprobacionDto(Aprobacion aprobacion) {
        if (aprobacion == null) {
            return null;
        }
        
        AprobacionDto dto = new AprobacionDto();
        dto.setAprobado(aprobacion.getAprobado());
        dto.setFechaAprobacion(formatDateTime(aprobacion.getFechaAprobacion()));
        dto.setUsuarioAprobacion(aprobacion.getUsuarioAprobacion());
        dto.setComentarioAprobacion(aprobacion.getComentarioAprobacion());
        
        return dto;
    }

    public static ResumenPaquetesDto toResumenPaquetesDto(ResumenPaquetes resumen) {
        if (resumen == null) {
            return null;
        }
        
        ResumenPaquetesDto dto = new ResumenPaquetesDto();
        dto.setTotalPaquetes(resumen.getTotalPaquetes());
        dto.setPaquetesAprobados(resumen.getPaquetesAprobados());
        dto.setPaquetesPendientes(resumen.getPaquetesPendientes());
        dto.setPaquetesEnRevision(resumen.getPaquetesEnRevision());
        dto.setPorcentajeAvance(resumen.getPorcentajeAvance());
        dto.setPorcentajeAprobacion(resumen.getPorcentajeAprobacion());
        
        return dto;
    }

    public static PaginacionDto toPaginacionDto(InformacionPaginacion paginacion) {
        if (paginacion == null) {
            return null;
        }
        
        PaginacionDto dto = new PaginacionDto();
        dto.setTotalRegistros(paginacion.getTotalRegistros());
        dto.setTotalPaginas(paginacion.getTotalPaginas());
        dto.setPaginaActual(paginacion.getPaginaActual());
        dto.setRegistrosPorPagina(paginacion.getRegistrosPorPagina());
        dto.setTieneAnterior(paginacion.getTieneAnterior());
        dto.setTieneSiguiente(paginacion.getTieneSiguiente());
        
        return dto;
    }

    public static TrazabilidadDto toTrazabilidadDto(InformacionTrazabilidad trazabilidad) {
        if (trazabilidad == null) {
            return null;
        }
        
        TrazabilidadDto dto = new TrazabilidadDto();
        dto.setAccion(trazabilidad.getAccion());
        dto.setFechaAccion(formatDateTime(trazabilidad.getFechaAccion()));
        dto.setUsuarioAccion(trazabilidad.getUsuarioAccion());
        dto.setIpOrigen(trazabilidad.getIpOrigen());
        dto.setDetalleAccion(trazabilidad.getDetalleAccion());
        
        return dto;
    }

    public static ConfirmacionDto toConfirmacionDto(Confirmacion confirmacion) {
        if (confirmacion == null) {
            return null;
        }
        
        ConfirmacionDto dto = new ConfirmacionDto();
        dto.setConfirmado(confirmacion.getConfirmado());
        dto.setFechaConfirmacion(formatDateTime(confirmacion.getFechaConfirmacion()));
        dto.setUsuarioConfirmacion(confirmacion.getUsuarioConfirmacion());
        dto.setComentarioConfirmacion(confirmacion.getComentarioConfirmacion());
        
        return dto;
    }

    public static SiguientePasoDto toSiguientePasoDto(InformacionSiguientePaso siguientePaso) {
        if (siguientePaso == null) {
            return null;
        }
        
        SiguientePasoDto dto = new SiguientePasoDto();
        dto.setAccion(siguientePaso.getAccion());
        dto.setDescripcion(siguientePaso.getDescripcion());
        dto.setPlantillaSugerida(siguientePaso.getPlantillaSugerida());
        
        return dto;
    }

    private static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(ISO_FORMATTER);
    }
}
