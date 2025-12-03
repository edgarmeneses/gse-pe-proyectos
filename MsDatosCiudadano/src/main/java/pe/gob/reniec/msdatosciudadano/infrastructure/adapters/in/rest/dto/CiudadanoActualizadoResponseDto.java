package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO que representa la respuesta cuando un ciudadano ha sido actualizado.
 * Estructura solicitada:
 * {
 *   "id": "string",
 *   "fechaCreacion": { "string": "YYYY-MM-DDThh:mm:ssZ" },
 *   "fechaActualizacion": { "string": "YYYY-MM-DDThh:mm:ssZ" },
 *   "DatosActualizados": "ArrayObject"
 * }
 */
public record CiudadanoActualizadoResponseDto(
        String id,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        List<Object> DatosActualizados
) {
}

