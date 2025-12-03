package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;

public class Diligencia {
    
    private Long id;
    private String numeroDiligencia;
    private LocalDateTime fechaDiligencia;
    private String tipoDiligencia;
    private String estado;
    private String descripcion;
    private Long solicitudId;
    
    public Diligencia() {
    }
    
    public Diligencia(Long id, String numeroDiligencia, LocalDateTime fechaDiligencia, 
                      String tipoDiligencia, String estado, String descripcion, Long solicitudId) {
        this.id = id;
        this.numeroDiligencia = numeroDiligencia;
        this.fechaDiligencia = fechaDiligencia;
        this.tipoDiligencia = tipoDiligencia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.solicitudId = solicitudId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumeroDiligencia() {
        return numeroDiligencia;
    }
    
    public void setNumeroDiligencia(String numeroDiligencia) {
        this.numeroDiligencia = numeroDiligencia;
    }
    
    public LocalDateTime getFechaDiligencia() {
        return fechaDiligencia;
    }
    
    public void setFechaDiligencia(LocalDateTime fechaDiligencia) {
        this.fechaDiligencia = fechaDiligencia;
    }
    
    public String getTipoDiligencia() {
        return tipoDiligencia;
    }
    
    public void setTipoDiligencia(String tipoDiligencia) {
        this.tipoDiligencia = tipoDiligencia;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Long getSolicitudId() {
        return solicitudId;
    }
    
    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }
}
