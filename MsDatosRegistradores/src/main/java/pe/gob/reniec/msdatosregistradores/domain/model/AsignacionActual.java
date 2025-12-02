package pe.gob.reniec.msdatosregistradores.domain.model;

import java.time.LocalDateTime;

public class AsignacionActual {
    private String codigoLocal;
    private String descripcionLocal;
    private String codigoEstadoRegistrador;
    private String descripcionEstado;
    private LocalDateTime fechaAsignacion;

    public AsignacionActual() {
    }

    public AsignacionActual(String codigoLocal, String descripcionLocal, 
                           String codigoEstadoRegistrador, String descripcionEstado, 
                           LocalDateTime fechaAsignacion) {
        this.codigoLocal = codigoLocal;
        this.descripcionLocal = descripcionLocal;
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
        this.descripcionEstado = descripcionEstado;
        this.fechaAsignacion = fechaAsignacion;
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

    public String getCodigoEstadoRegistrador() {
        return codigoEstadoRegistrador;
    }

    public void setCodigoEstadoRegistrador(String codigoEstadoRegistrador) {
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
