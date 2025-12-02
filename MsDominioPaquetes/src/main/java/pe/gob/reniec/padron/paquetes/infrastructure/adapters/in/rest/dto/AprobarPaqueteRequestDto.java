package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record AprobarPaqueteRequestDto(
    InformacionPublicacionDto informacionPublicacion,
    String comentarioAprobacion,
    Boolean confirmarIntegridad
) {}
