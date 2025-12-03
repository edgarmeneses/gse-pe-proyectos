package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record SeguimientoDto(
        Long reiteracionesPermitidas,
        LocalDateTime proximaRevision,
        Boolean alertasConfiguradas
) {
}
