package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record que representa un documento evaluado
 */
public record DocumentoEvaluadoDto(
    String documentoId,
    String tipoDocumental,
    String nombreArchivo,
    String estadoEvaluacion,
    Double scoreConfiabilidad,
    String nivelRiesgo,
    Boolean alertaFraude,
    List<ObservacionDto> observaciones,
    MetricasDto metricas,
    Long tiempoProcesamientoMs
) {}
