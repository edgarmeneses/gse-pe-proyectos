package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record que representa los datos de la evaluación
 */
public record EvaluacionDataDto(
    String evaluacionId,
    String solicitudId,
    String tramiteId,
    String fechaEvaluacion,
    String modeloIAUtilizado,
    Long tiempoProcesamientoMs,
    ResultadoGeneralDto resultadoGeneral,
    List<DocumentoEvaluadoDto> documentosEvaluados,
    List<AccionRecomendadaDto> accionesRecomendadas
) {}
