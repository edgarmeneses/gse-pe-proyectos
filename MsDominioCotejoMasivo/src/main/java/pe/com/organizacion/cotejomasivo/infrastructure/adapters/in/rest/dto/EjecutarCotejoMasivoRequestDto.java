package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Request: EjecutarCotejoMasivoRequestDto
 * Representa la solicitud para ejecutar un cotejo masivo
 */
public record EjecutarCotejoMasivoRequestDto(
    List<CriterioCotejoDto> criteriosCotejo,
    String usuarioSolicitante
) {
}
