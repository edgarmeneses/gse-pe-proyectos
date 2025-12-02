package pe.gob.reniec.certificadosdigitales.domain.model;

import java.time.LocalDateTime;

public class PasoProceso {
    private String estado;
    private String solicitudPkiId;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long intentos;

    public PasoProceso() {
    }

    public PasoProceso(String estado, String solicitudPkiId, LocalDateTime fechaInicio,
                       LocalDateTime fechaFin, Long intentos) {
        this.estado = estado;
        this.solicitudPkiId = solicitudPkiId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.intentos = intentos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSolicitudPkiId() {
        return solicitudPkiId;
    }

    public void setSolicitudPkiId(String solicitudPkiId) {
        this.solicitudPkiId = solicitudPkiId;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getIntentos() {
        return intentos;
    }

    public void setIntentos(Long intentos) {
        this.intentos = intentos;
    }
}
