package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO: CriterioCotejoDto
 * Representa un criterio de cotejo en las peticiones/respuestas
 */
public record CriterioCotejoDto(
    String campo,
    String operador,
    String valor
) {
}
