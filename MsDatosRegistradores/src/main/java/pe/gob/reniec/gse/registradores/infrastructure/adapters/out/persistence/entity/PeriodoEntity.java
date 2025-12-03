package pe.gob.reniec.gse.registradores.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

/**
 * Entity de persistencia: PeriodoEntity
 * Representa la estructura de datos para persistir un periodo de asignación.
 * NOTA: Sin anotaciones JPA - POJO puro.
 */
public class PeriodoEntity {
    
    private String idPeriodo;
    private String idRegistrador;
    private String codigoLocal;
    private String descripcionLocal;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;
    
    public PeriodoEntity() {
    }
    
    // Getters y Setters
    
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
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
