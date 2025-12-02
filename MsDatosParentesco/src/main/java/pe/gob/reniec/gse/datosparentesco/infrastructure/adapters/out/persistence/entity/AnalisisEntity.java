package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class AnalisisEntity {
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

    public AnalisisEntity() {
    }

    public AnalisisEntity(String idAnalisis, String idSolicitud, String idCiudadanoConsultado, String tipoVinculo,
                          Integer nivelComplejidad, String criteriosBusquedaJson, String estado,
                          String resultadoAnalisis, String usuarioTecnico, LocalDateTime fechaCreacion,
                          LocalDateTime fechaModificacion, String observaciones) {
        this.idAnalisis = idAnalisis;
        this.idSolicitud = idSolicitud;
        this.idCiudadanoConsultado = idCiudadanoConsultado;
        this.tipoVinculo = tipoVinculo;
        this.nivelComplejidad = nivelComplejidad;
        this.criteriosBusquedaJson = criteriosBusquedaJson;
        this.estado = estado;
        this.resultadoAnalisis = resultadoAnalisis;
        this.usuarioTecnico = usuarioTecnico;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.observaciones = observaciones;
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
