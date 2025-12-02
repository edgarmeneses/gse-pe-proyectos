package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

public record CarpetaRequestDto(
    String nombre,
    String parentId,
    String descripcion
) {}
