package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record ResumenSolicitudDto(
    Long totalRegistros,
    String prioridad,
    String tiempoEstimadoProcesamiento
) {}
