package pe.gob.reniec.certificadosdigitales.domain.model;

import java.time.LocalDateTime;

public class Transaccion {
    private String transaccionId;
    private String codigoSolicitudTramite;
    private String estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long tiempoProcesamientoMs;

    public Transaccion() {
    }

    public Transaccion(String transaccionId, String codigoSolicitudTramite, String estado,
                       LocalDateTime fechaInicio, LocalDateTime fechaFin, Long tiempoProcesamientoMs) {
        this.transaccionId = transaccionId;
        this.codigoSolicitudTramite = codigoSolicitudTramite;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public String getCodigoSolicitudTramite() {
        return codigoSolicitudTramite;
    }

    public void setCodigoSolicitudTramite(String codigoSolicitudTramite) {
        this.codigoSolicitudTramite = codigoSolicitudTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Long getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }
}
