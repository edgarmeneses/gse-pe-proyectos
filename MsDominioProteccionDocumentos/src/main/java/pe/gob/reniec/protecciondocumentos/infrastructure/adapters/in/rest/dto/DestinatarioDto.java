package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record DestinatarioDto(
    String email,
    String telefono,
    String nombreCompleto
) {}
