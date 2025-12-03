package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Actualizar Carpeta
 */
public record ActualizarCarpetaResponseDto(
    String id,
    String updatedAt,
    List<String> camposActualizados
) {}
