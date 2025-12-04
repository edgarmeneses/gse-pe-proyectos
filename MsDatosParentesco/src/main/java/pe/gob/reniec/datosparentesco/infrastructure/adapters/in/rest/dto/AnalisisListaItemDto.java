package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para representar un análisis en la lista.
 */
public class AnalisisListaItemDto {
    
    private String idAnalisis;
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private String estado;
    private String usuarioTecnico;
    private String fechaCreacion;
    
    public AnalisisListaItemDto() {
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
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
