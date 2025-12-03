package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response: Crear Carpeta
 */
public record CrearCarpetaResponseDto(
    String id,
    String createdAt,
    String estadoCarpeta,
    String ruta
) {}
