package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO de Response: ConsultarCotejoMasivoResponseDto
 * Representa la respuesta al consultar el estado de un cotejo masivo
 */
public record ConsultarCotejoMasivoResponseDto(
    String idEjecucion,
    LocalDateTime fechaSolicitud,
    String estado,
    Long totalRegistros,
    Long registrosProcesados,
    Long registrosExitosos,
    Long registrosConError,
    LocalDateTime fechaInicio,
    LocalDateTime fechaFin,
    String usuarioSolicitante,
    Long statusCode,
    String mensaje
) {
}
