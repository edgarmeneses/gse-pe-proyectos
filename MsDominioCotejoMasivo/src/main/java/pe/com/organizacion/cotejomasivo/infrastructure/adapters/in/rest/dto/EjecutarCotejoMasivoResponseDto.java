package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO de Response: EjecutarCotejoMasivoResponseDto
 * Representa la respuesta al ejecutar un cotejo masivo
 */
public record EjecutarCotejoMasivoResponseDto(
    String idEjecucion,
    LocalDateTime fechaSolicitud,
    String estado,
    Long statusCode,
    String mensaje
) {
}
