package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public final class SeguimientoDto {
    private final Long reiteracionesPermitidas;
    private final LocalDateTime proximaRevision;
    private final Boolean alertasConfiguradas;

    public SeguimientoDto(Long reiteracionesPermitidas, LocalDateTime proximaRevision, Boolean alertasConfiguradas) {
        this.reiteracionesPermitidas = reiteracionesPermitidas;
        this.proximaRevision = proximaRevision;
        this.alertasConfiguradas = alertasConfiguradas;
    }

    public Long reiteracionesPermitidas() { return reiteracionesPermitidas; }
    public LocalDateTime proximaRevision() { return proximaRevision; }
    public Boolean alertasConfiguradas() { return alertasConfiguradas; }
}
