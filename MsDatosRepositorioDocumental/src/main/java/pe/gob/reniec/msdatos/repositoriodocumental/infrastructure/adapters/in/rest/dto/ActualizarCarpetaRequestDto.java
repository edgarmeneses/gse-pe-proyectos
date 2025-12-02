package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

public record ActualizarCarpetaRequestDto(
    String nombre,
    String estadoCarpeta,
    String parentId,
    String descripcion
) {}
