package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record ResumenPaquetesDto(
    int totalPaquetes,
    int paquetesAprobados,
    float porcentajeAprobacion
) {}
