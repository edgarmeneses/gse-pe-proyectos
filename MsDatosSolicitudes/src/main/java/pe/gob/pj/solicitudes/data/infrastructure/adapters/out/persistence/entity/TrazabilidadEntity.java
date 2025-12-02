package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class TrazabilidadEntity {
    
    private Long id;
    private Long solicitudId;
    private LocalDateTime fecha;
    private String accion;
    private String usuario;
    private String detalle;
    
    public TrazabilidadEntity() {
    }
    
    public TrazabilidadEntity(Long id, Long solicitudId, LocalDateTime fecha,
                              String accion, String usuario, String detalle) {
        this.id = id;
        this.solicitudId = solicitudId;
        this.fecha = fecha;
        this.accion = accion;
        this.usuario = usuario;
        this.detalle = detalle;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getSolicitudId() {
        return solicitudId;
    }
    
    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public String getAccion() {
        return accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
