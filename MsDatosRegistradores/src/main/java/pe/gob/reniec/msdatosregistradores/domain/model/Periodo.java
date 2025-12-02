package pe.gob.reniec.msdatosregistradores.domain.model;

import java.time.LocalDate;

public class Periodo {
    private String idPeriodo;
    private String codigoLocal;
    private String descripcionLocal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public Periodo() {
    }

    public Periodo(String idPeriodo, String codigoLocal, String descripcionLocal, 
                  LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.idPeriodo = idPeriodo;
        this.codigoLocal = codigoLocal;
        this.descripcionLocal = descripcionLocal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
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
