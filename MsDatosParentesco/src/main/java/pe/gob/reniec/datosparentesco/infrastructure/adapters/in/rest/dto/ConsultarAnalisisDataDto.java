package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de datos para consultar un análisis de parentesco específico.
 */
public class ConsultarAnalisisDataDto {
    
    private String idAnalisis;
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private CriteriosBusquedaDto criteriosBusqueda;
    private String estado;
    private String resultadoAnalisis;
    private String usuarioTecnico;
    private String fechaCreacion;
    private String fechaModificacion;
    private String observaciones;
    
    public ConsultarAnalisisDataDto() {
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
    
    public CriteriosBusquedaDto getCriteriosBusqueda() {
        return criteriosBusqueda;
    }
    
    public void setCriteriosBusqueda(CriteriosBusquedaDto criteriosBusqueda) {
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
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getFechaModificacion() {
        return fechaModificacion;
    }
    
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
