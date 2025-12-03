package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Solicitud {
    
    private Long id;
    private String numeroSolicitud;
    private LocalDateTime fechaSolicitud;
    private String tipoSolicitud;
    private String estado;
    private String solicitante;
    private String descripcion;
    private List<Diligencia> diligencias;
    
    public Solicitud() {
    }
    
    public Solicitud(Long id, String numeroSolicitud, LocalDateTime fechaSolicitud, 
                     String tipoSolicitud, String estado, String solicitante, 
                     String descripcion, List<Diligencia> diligencias) {
        this.id = id;
        this.numeroSolicitud = numeroSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.estado = estado;
        this.solicitante = solicitante;
        this.descripcion = descripcion;
        this.diligencias = diligencias;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }
    
    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }
    
    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }
    
    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getSolicitante() {
        return solicitante;
    }
    
    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Diligencia> getDiligencias() {
        return diligencias;
    }
    
    public void setDiligencias(List<Diligencia> diligencias) {
        this.diligencias = diligencias;
    }
}
