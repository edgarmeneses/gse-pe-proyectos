package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.*;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre DTOs y modelos de dominio para calificación de documentos
 */
public class CalificarDocumentoDtoMapper {
    
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    
    /**
     * Convierte el DTO de request a modelo de dominio
     */
    public SolicitudCalificacion toDomain(CalificarDocumentoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        SolicitudCalificacion solicitud = new SolicitudCalificacion();
        solicitud.setSolicitudId(dto.solicitudId());
        solicitud.setTramiteId(dto.tramiteId());
        solicitud.setTipoTramite(dto.tipoTramite());
        solicitud.setDocumentos(toDocumentosDomain(dto.documentos()));
        solicitud.setParametrosValidacion(toParametrosValidacionDomain(dto.parametrosValidacion()));
        solicitud.setUsuarioSolicita(dto.usuarioSolicita());
        solicitud.setOficinaOrigen(dto.oficinaOrigen());
        solicitud.setFechaSolicitud(parseFecha(dto.fechaSolicitud()));
        solicitud.setObservaciones(dto.observaciones());
        
        return solicitud;
    }
    
    /**
     * Convierte el modelo de dominio de evaluación a DTO de respuesta
     */
    public CalificarDocumentoResponseDto toResponseDto(EvaluacionDocumento evaluacion) {
        if (evaluacion == null) {
            return null;
        }
        
        EvaluacionDataDto dataDto = new EvaluacionDataDto(
            evaluacion.getEvaluacionId(),
            evaluacion.getSolicitudId(),
            evaluacion.getTramiteId(),
            formatFecha(evaluacion.getFechaEvaluacion()),
            evaluacion.getModeloIAUtilizado(),
            evaluacion.getTiempoProcesamientoMs(),
            toResultadoGeneralDto(evaluacion.getResultadoGeneral()),
            toDocumentosEvaluadosDto(evaluacion.getDocumentosEvaluados()),
            toAccionesRecomendadasDto(evaluacion.getAccionesRecomendadas())
        );
        
        MetadataDto metadata = new MetadataDto(
            formatFecha(LocalDateTime.now()),
            evaluacion.getEvaluacionId(),
            "v1",
            "server-01"
        );
        
        return new CalificarDocumentoResponseDto(true, dataDto, metadata);
    }
    
    private List<Documento> toDocumentosDomain(List<DocumentoDto> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(this::toDocumentoDomain)
                .collect(Collectors.toList());
    }
    
    private Documento toDocumentoDomain(DocumentoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Documento(
            dto.documentoId(),
            dto.tipoDocumental(),
            dto.nombreArchivo(),
            dto.rutaGestorDocumental(),
            dto.hashSHA256(),
            dto.formatoDocumento(),
            dto.tamanioBytes(),
            dto.requiereValidacionIA()
        );
    }
    
    private ParametrosValidacion toParametrosValidacionDomain(ParametrosValidacionDto dto) {
        if (dto == null) {
            return null;
        }
        return new ParametrosValidacion(
            dto.nivelPonderacionMinimo(),
            dto.modeloIA(),
            toTiposObservacionDomain(dto.tiposObservacion())
        );
    }
    
    private List<TipoObservacion> toTiposObservacionDomain(List<TipoObservacionDto> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(dto -> new TipoObservacion(dto.codigo(), dto.descripcion()))
                .collect(Collectors.toList());
    }
    
    private ResultadoGeneralDto toResultadoGeneralDto(ResultadoGeneral domain) {
        if (domain == null) {
            return null;
        }
        return new ResultadoGeneralDto(
            domain.getEstado(),
            domain.getScorePromedio(),
            domain.getNivelRiesgo(),
            domain.getAlertaFraude(),
            domain.getRequiereRevisionManual(),
            domain.getObservacionesGenerales()
        );
    }
    
    private List<DocumentoEvaluadoDto> toDocumentosEvaluadosDto(List<DocumentoEvaluado> domain) {
        if (domain == null) {
            return null;
        }
        return domain.stream()
                .map(this::toDocumentoEvaluadoDto)
                .collect(Collectors.toList());
    }
    
    private DocumentoEvaluadoDto toDocumentoEvaluadoDto(DocumentoEvaluado domain) {
        if (domain == null) {
            return null;
        }
        return new DocumentoEvaluadoDto(
            domain.getDocumentoId(),
            domain.getTipoDocumental(),
            domain.getNombreArchivo(),
            domain.getEstadoEvaluacion(),
            domain.getScoreConfiabilidad(),
            domain.getNivelRiesgo(),
            domain.getAlertaFraude(),
            toObservacionesDto(domain.getObservaciones()),
            toMetricasDto(domain.getMetricas()),
            domain.getTiempoProcesamientoMs()
        );
    }
    
    private List<ObservacionDto> toObservacionesDto(List<Observacion> domain) {
        if (domain == null) {
            return null;
        }
        return domain.stream()
                .map(obs -> new ObservacionDto(
                    obs.getCodigo(),
                    obs.getDescripcion(),
                    obs.getSeveridad(),
                    obs.getEvidencias()
                ))
                .collect(Collectors.toList());
    }
    
    private MetricasDto toMetricasDto(Metricas domain) {
        if (domain == null) {
            return null;
        }
        return new MetricasDto(
            domain.getCalidadImagen(),
            domain.getLegibilidadTexto(),
            domain.getIntegridadEstructura(),
            domain.getConfianzaOCR()
        );
    }
    
    private List<AccionRecomendadaDto> toAccionesRecomendadasDto(List<AccionRecomendada> domain) {
        if (domain == null) {
            return null;
        }
        return domain.stream()
                .map(accion -> new AccionRecomendadaDto(
                    accion.getTipo(),
                    accion.getDescripcion(),
                    accion.getPrioridad()
                ))
                .collect(Collectors.toList());
    }
    
    private LocalDateTime parseFecha(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(fecha, ISO_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
    
    private String formatFecha(LocalDateTime fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.format(ISO_FORMATTER);
    }
}
