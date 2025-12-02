package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record RepresentanteLegalDto(
    String dni,
    String nombres,
    String apellidoPaterno,
    String apellidoMaterno
) {}
