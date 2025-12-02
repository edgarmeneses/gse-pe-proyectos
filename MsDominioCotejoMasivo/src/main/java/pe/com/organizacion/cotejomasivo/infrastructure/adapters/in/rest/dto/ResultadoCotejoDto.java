package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO: ResultadoCotejoDto
 * Representa el resultado de cotejo de un registro individual
 */
public record ResultadoCotejoDto(
    String idRegistro,
    String estadoCotejo,
    String detalles,
    LocalDateTime fechaProcesamiento
) {
}
