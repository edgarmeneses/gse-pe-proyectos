package pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

/**
 * Entidad de persistencia para AnalisisParentesco.
 * POJO sin anotaciones JPA/frameworks.
 */
public class AnalisisParentescoEntity {
    
    private String idAnalisis;
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private String criteriosBusquedaJson;
    private String estado;
    private String resultadoAnalisis;
    private String usuarioTecnico;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String observaciones;
    
    public AnalisisParentescoEntity() {
    }
    
    public String getIdAnalisis() {
        return idAnalisis;
    }
    
    public void setIdAnalisis(String idAnalisis) {
        this.idAnalisis = idAnalisis;
    }
    
    public String getIdSolicitud() {
        return idSolicitud;
    }
    
    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
    public String getIdCiudadanoConsultado() {
        return idCiudadanoConsultado;
    }
    
    public void setIdCiudadanoConsultado(String idCiudadanoConsultado) {
        this.idCiudadanoConsultado = idCiudadanoConsultado;
    }
    
    public String getTipoVinculo() {
        return tipoVinculo;
    }
    
    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }
    
    public Integer getNivelComplejidad() {
        return nivelComplejidad;
    }
    
    public void setNivelComplejidad(Integer nivelComplejidad) {
        this.nivelComplejidad = nivelComplejidad;
    }
    
    public String getCriteriosBusquedaJson() {
        return criteriosBusquedaJson;
    }
    
    public void setCriteriosBusquedaJson(String criteriosBusquedaJson) {
        this.criteriosBusquedaJson = criteriosBusquedaJson;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getResultadoAnalisis() {
        return resultadoAnalisis;
    }
    
    public void setResultadoAnalisis(String resultadoAnalisis) {
        this.resultadoAnalisis = resultadoAnalisis;
    }
    
    public String getUsuarioTecnico() {
        return usuarioTecnico;
    }
    
    public void setUsuarioTecnico(String usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
    
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
