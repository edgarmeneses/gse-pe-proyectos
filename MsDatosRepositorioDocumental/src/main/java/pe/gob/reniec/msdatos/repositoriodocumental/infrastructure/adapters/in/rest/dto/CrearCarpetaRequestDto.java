package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Request: Crear Carpeta
 */
public record CrearCarpetaRequestDto(
    String nombre,
    String parentId,
    String descripcion
) {}
