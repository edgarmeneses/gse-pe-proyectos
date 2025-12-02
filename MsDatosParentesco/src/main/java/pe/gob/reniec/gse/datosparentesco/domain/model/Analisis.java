package pe.gob.reniec.gse.datosparentesco.domain.model;

import java.time.LocalDateTime;

public class Analisis {
    private String idAnalisis;
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private CriteriosBusqueda criteriosBusqueda;
    private String estado;
    private String resultadoAnalisis;
    private String usuarioTecnico;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String observaciones;

    public Analisis() {
    }

    public Analisis(String idAnalisis, String idSolicitud, String idCiudadanoConsultado, String tipoVinculo,
                    Integer nivelComplejidad, CriteriosBusqueda criteriosBusqueda, String estado,
                    String resultadoAnalisis, String usuarioTecnico, LocalDateTime fechaCreacion,
                    LocalDateTime fechaModificacion, String observaciones) {
        this.idAnalisis = idAnalisis;
        this.idSolicitud = idSolicitud;
        this.idCiudadanoConsultado = idCiudadanoConsultado;
        this.tipoVinculo = tipoVinculo;
        this.nivelComplejidad = nivelComplejidad;
        this.criteriosBusqueda = criteriosBusqueda;
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

    public CriteriosBusqueda getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(CriteriosBusqueda criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
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
