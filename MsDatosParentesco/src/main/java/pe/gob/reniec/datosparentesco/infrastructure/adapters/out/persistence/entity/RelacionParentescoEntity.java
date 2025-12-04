package pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

/**
 * Entidad de persistencia para RelacionParentesco.
 * POJO sin anotaciones JPA/frameworks.
 */
public class RelacionParentescoEntity {
    
    private Long idRelacion;
    private String idAnalisis;
    private String idCiudadanoOrigen;
    private String idCiudadanoDestino;
    private String tipoParentesco;
    private String descripcionParentesco;
    private Integer gradoParentesco;
    private String idActaSustento;
    private String idDocumentoSustento;
    private LocalDateTime fechaInicioVigencia;
    private LocalDateTime fechaRegistro;
    private Boolean vigente;
    private String observacion;
    private Long idRelacionInversa;
    private String codigoTipoRelacionInversa;
    
    public RelacionParentescoEntity() {
    }
    
    public Long getIdRelacion() {
        return idRelacion;
    }
    
    public void setIdRelacion(Long idRelacion) {
        this.idRelacion = idRelacion;
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
    
    public String getTipoParentesco() {
        return tipoParentesco;
    }
    
    public void setTipoParentesco(String tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }
    
    public String getDescripcionParentesco() {
        return descripcionParentesco;
    }
    
    public void setDescripcionParentesco(String descripcionParentesco) {
        this.descripcionParentesco = descripcionParentesco;
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
    
    public LocalDateTime getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    
    public void setFechaInicioVigencia(LocalDateTime fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Boolean getVigente() {
        return vigente;
    }
    
    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
    
    public String getObservacion() {
        return observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public Long getIdRelacionInversa() {
        return idRelacionInversa;
    }
    
    public void setIdRelacionInversa(Long idRelacionInversa) {
        this.idRelacionInversa = idRelacionInversa;
    }
    
    public String getCodigoTipoRelacionInversa() {
        return codigoTipoRelacionInversa;
    }
    
    public void setCodigoTipoRelacionInversa(String codigoTipoRelacionInversa) {
        this.codigoTipoRelacionInversa = codigoTipoRelacionInversa;
    }
}
