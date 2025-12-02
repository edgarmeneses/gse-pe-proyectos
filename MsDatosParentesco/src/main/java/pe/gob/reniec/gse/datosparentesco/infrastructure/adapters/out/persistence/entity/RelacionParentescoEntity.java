package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RelacionParentescoEntity {
    private Long idRelacion;
    private String idAnalisis;
    private String idCiudadanoOrigen;
    private String idCiudadanoDestino;
    private String codigoTipoParentesco;
    private Integer gradoParentesco;
    private String idActaSustento;
    private String idDocumentoSustento;
    private LocalDate fechaInicioVigencia;
    private LocalDateTime fechaRegistro;
    private String observacion;
    private Boolean vigente;

    public RelacionParentescoEntity() {
    }

    public RelacionParentescoEntity(Long idRelacion, String idAnalisis, String idCiudadanoOrigen,
                                    String idCiudadanoDestino, String codigoTipoParentesco, Integer gradoParentesco,
                                    String idActaSustento, String idDocumentoSustento, LocalDate fechaInicioVigencia,
                                    LocalDateTime fechaRegistro, String observacion, Boolean vigente) {
        this.idRelacion = idRelacion;
        this.idAnalisis = idAnalisis;
        this.idCiudadanoOrigen = idCiudadanoOrigen;
        this.idCiudadanoDestino = idCiudadanoDestino;
        this.codigoTipoParentesco = codigoTipoParentesco;
        this.gradoParentesco = gradoParentesco;
        this.idActaSustento = idActaSustento;
        this.idDocumentoSustento = idDocumentoSustento;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaRegistro = fechaRegistro;
        this.observacion = observacion;
        this.vigente = vigente;
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

    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
}
