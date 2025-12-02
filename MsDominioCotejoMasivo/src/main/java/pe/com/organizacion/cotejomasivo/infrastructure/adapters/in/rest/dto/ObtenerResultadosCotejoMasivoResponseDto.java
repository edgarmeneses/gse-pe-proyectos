package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Response: ObtenerResultadosCotejoMasivoResponseDto
 * Representa la respuesta con resultados paginados de un cotejo masivo
 */
public record ObtenerResultadosCotejoMasivoResponseDto(
    String idEjecucion,
    String estado,
    List<ResultadoCotejoDto> resultados,
    Long paginaActual,
    Long tamanio,
    Long totalResultados,
    Long totalPaginas,
    Long statusCode,
    String mensaje
) {
}
