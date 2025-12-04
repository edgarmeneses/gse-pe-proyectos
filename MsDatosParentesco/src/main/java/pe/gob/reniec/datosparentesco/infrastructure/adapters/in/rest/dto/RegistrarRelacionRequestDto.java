package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de request para registrar una relación de parentesco.
 */
public class RegistrarRelacionRequestDto {
    
    private String idAnalisis;
    private String idCiudadanoOrigen;
    private String idCiudadanoDestino;
    private String codigoTipoParentesco;
    private Integer gradoParentesco;
    private String idActaSustento;
    private String idDocumentoSustento;
    private String fechaInicioVigencia;
    private String observacion;
    
    public RegistrarRelacionRequestDto() {
    }
    
    public String getIdAnalisis() {
        return idAnalisis;
    }
    
    public void setIdAnalisis(String idAnalisis) {
        this.idAnalisis = idAnalisis;
    }
    
    public String getIdCiudadanoOrigen() {
        return idCiudadanoOrigen;
    }
    
    public void setIdCiudadanoOrigen(String idCiudadanoOrigen) {
        this.idCiudadanoOrigen = idCiudadanoOrigen;
    }
    
    public String getIdCiudadanoDestino() {
        return idCiudadanoDestino;
    }
    
    public void setIdCiudadanoDestino(String idCiudadanoDestino) {
        this.idCiudadanoDestino = idCiudadanoDestino;
    }
    
    public String getCodigoTipoParentesco() {
        return codigoTipoParentesco;
    }
    
    public void setCodigoTipoParentesco(String codigoTipoParentesco) {
        this.codigoTipoParentesco = codigoTipoParentesco;
    }
    
    public Integer getGradoParentesco() {
        return gradoParentesco;
    }
    
    public void setGradoParentesco(Integer gradoParentesco) {
        this.gradoParentesco = gradoParentesco;
    }
    
    public String getIdActaSustento() {
        return idActaSustento;
    }
    
    public void setIdActaSustento(String idActaSustento) {
        this.idActaSustento = idActaSustento;
    }
    
    public String getIdDocumentoSustento() {
        return idDocumentoSustento;
    }
    
    public void setIdDocumentoSustento(String idDocumentoSustento) {
        this.idDocumentoSustento = idDocumentoSustento;
    }
    
    public String getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    
    public void setFechaInicioVigencia(String fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
    
    public String getObservacion() {
        return observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
