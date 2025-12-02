package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record ConfirmarRevisionRequestDto(
    String tipoPadron,
    String comentarioConfirmacion,
    Boolean confirmarRevisionCompleta
) {}
