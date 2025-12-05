package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.validadordocumentos.domain.model.*;
import pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper que transforma entre DTOs de la capa REST y entidades del dominio.
 * Realiza conversión bidireccional sin dependencias de frameworks.
 */
public class EvaluacionDocumentoDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    /**
     * Convierte un DTO de request a entidad del dominio.
     *
     * @param dto DTO de entrada
     * @return Entidad del dominio
     */
    public EvaluacionDocumento toDomain(EvaluacionDocumentoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        EvaluacionDocumento evaluacion = new EvaluacionDocumento();
        evaluacion.setEvaluacionId(dto.getEvaluacionId());
        evaluacion.setSolicitudId(dto.getSolicitudId());
        evaluacion.setTramiteId(dto.getTramiteId());
        evaluacion.setFechaEvaluacion(parseDateTime(dto.getFechaEvaluacion()));
        evaluacion.setModeloIAUtilizado(dto.getModeloIAUtilizado());
        evaluacion.setTiempoProcesamientoMs(dto.getTiempoProcesamientoMs());
        evaluacion.setResultadoGeneral(toResultadoGeneral(dto.getResultadoGeneral()));
        evaluacion.setDocumentosEvaluados(toDocumentosEvaluados(dto.getDocumentosEvaluados()));
        evaluacion.setAccionesRecomendadas(toAccionesRecomendadas(dto.getAccionesRecomendadas()));
        evaluacion.setUsuarioSolicita(dto.getUsuarioSolicita());
        evaluacion.setOficinaOrigen(dto.getOficinaOrigen());

        return evaluacion;
    }

    /**
     * Convierte una entidad del dominio a DTO de respuesta.
     *
     * @param evaluacion Entidad del dominio
     * @return DTO de respuesta
     */
    public EvaluacionDocumentoResponseDto toResponseDto(EvaluacionDocumento evaluacion) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    private ResultadoGeneral toResultadoGeneral(ResultadoGeneralDto dto) {
        if (dto == null) {
            return null;
        }

        return new ResultadoGeneral(
                dto.getEstado(),
                dto.getScorePromedio(),
                dto.getNivelRiesgo(),
                dto.getAlertaFraude(),
                dto.getRequiereRevisionManual(),
                dto.getObservacionesGenerales()
        );
    }

    private List<DocumentoEvaluado> toDocumentosEvaluados(List<DocumentoEvaluadoDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toDocumentoEvaluado)
                .collect(Collectors.toList());
    }

    private DocumentoEvaluado toDocumentoEvaluado(DocumentoEvaluadoDto dto) {
        if (dto == null) {
            return null;
        }

        DocumentoEvaluado documento = new DocumentoEvaluado();
        documento.setDocumentoId(dto.getDocumentoId());
        documento.setTipoDocumental(dto.getTipoDocumental());
        documento.setNombreArchivo(dto.getNombreArchivo());
        documento.setEstadoEvaluacion(dto.getEstadoEvaluacion());
        documento.setScoreConfiabilidad(dto.getScoreConfiabilidad());
        documento.setNivelRiesgo(dto.getNivelRiesgo());
        documento.setAlertaFraude(dto.getAlertaFraude());
        documento.setObservaciones(toObservaciones(dto.getObservaciones()));
        documento.setMetricas(toMetricas(dto.getMetricas()));
        documento.setTiempoProcesamientoMs(dto.getTiempoProcesamientoMs());

        return documento;
    }

    private List<Observacion> toObservaciones(List<ObservacionDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toObservacion)
                .collect(Collectors.toList());
    }

    private Observacion toObservacion(ObservacionDto dto) {
        if (dto == null) {
            return null;
        }

        return new Observacion(
                dto.getCodigo(),
                dto.getDescripcion(),
                dto.getSeveridad(),
                dto.getEvidencias()
        );
    }

    private Metricas toMetricas(MetricasDto dto) {
        if (dto == null) {
            return null;
        }

        return new Metricas(
                dto.getCalidadImagen(),
                dto.getLegibilidadTexto(),
                dto.getIntegridadEstructura(),
                dto.getConfianzaOCR()
        );
    }

    private List<AccionRecomendada> toAccionesRecomendadas(List<AccionRecomendadaDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toAccionRecomendada)
                .collect(Collectors.toList());
    }

    private AccionRecomendada toAccionRecomendada(AccionRecomendadaDto dto) {
        if (dto == null) {
            return null;
        }

        return new AccionRecomendada(
                dto.getTipo(),
                dto.getDescripcion(),
                dto.getPrioridad()
        );
    }

    private LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }

        try {
            return LocalDateTime.parse(dateTimeStr, ISO_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        return dateTime.format(ISO_FORMATTER);
    }
}
