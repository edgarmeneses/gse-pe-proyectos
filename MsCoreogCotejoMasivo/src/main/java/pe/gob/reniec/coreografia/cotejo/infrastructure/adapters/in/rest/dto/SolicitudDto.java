package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record SolicitudDto(
    String numeroSolicitud,
    String tipoTramite,
    String fechaSolicitud,
    String prioridad
) {}
