package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;

public class PeriodoEntity {
    private String idPeriodo;
    private String idRegistrador;
    private String codigoLocal;
    private String descripcionLocal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public PeriodoEntity() {
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(String idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getDescripcionLocal() {
        return descripcionLocal;
    }

    public void setDescripcionLocal(String descripcionLocal) {
        this.descripcionLocal = descripcionLocal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
