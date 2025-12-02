package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record ResumenDto(
    int totalPaquetes,
    int paquetesAprobados,
    int paquetesPendientes,
    int paquetesEnRevision,
    float porcentajeAvance
) {}
