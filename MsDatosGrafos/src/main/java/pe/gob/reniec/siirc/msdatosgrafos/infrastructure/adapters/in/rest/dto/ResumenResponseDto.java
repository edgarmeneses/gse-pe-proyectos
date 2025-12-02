package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para respuesta de resumen
 */
public record ResumenResponseDto(
    Long totalVinculos,
    Long vinculosConsanguineos,
    Long vinculosPorAfinidad,
    Long vinculosVigentes,
    Long vinculosNoVigentes
) {}
