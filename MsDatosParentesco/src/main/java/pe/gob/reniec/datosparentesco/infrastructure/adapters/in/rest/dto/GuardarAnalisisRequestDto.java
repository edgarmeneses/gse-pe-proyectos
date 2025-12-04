package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de request para guardar un análisis de parentesco.
 */
public class GuardarAnalisisRequestDto {
    
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private CriteriosBusquedaDto criteriosBusqueda;
    private String estado;
    private String usuarioTecnico;
    private String observaciones;
    
    public GuardarAnalisisRequestDto() {
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
    
    public String getUsuarioTecnico() {
        return usuarioTecnico;
    }
    
    public void setUsuarioTecnico(String usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
