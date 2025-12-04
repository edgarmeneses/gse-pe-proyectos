package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para vínculos de parentesco consanguíneo.
 */
public class VinculoConsanguineoDto {
    private Long idRelacion;
    private String idCiudadanoOrigen;
    private String idCiudadanoDestino;
    private String nombreCiudadanoDestino;
    private String codTipo;
    private String descripcionTipo;
    private String categoria;
    private Integer gradoMinimo;
    private String esSimetrico;
    private String codInverso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String idActaSustento;
    private ActaSustentoDto actaSustento;
    private String idDocumentoSustento;
    private Double nivelConfianza;
    private String estadoConfirmacion;
    private Boolean requiereValidacionManual;
    private String observacion;

    public VinculoConsanguineoDto() {}

    public Long getIdRelacion() { return idRelacion; }
    public void setIdRelacion(Long idRelacion) { this.idRelacion = idRelacion; }

    public String getIdCiudadanoOrigen() { return idCiudadanoOrigen; }
    public void setIdCiudadanoOrigen(String idCiudadanoOrigen) { this.idCiudadanoOrigen = idCiudadanoOrigen; }

    public String getIdCiudadanoDestino() { return idCiudadanoDestino; }
    public void setIdCiudadanoDestino(String idCiudadanoDestino) { this.idCiudadanoDestino = idCiudadanoDestino; }

    public String getNombreCiudadanoDestino() { return nombreCiudadanoDestino; }
    public void setNombreCiudadanoDestino(String nombreCiudadanoDestino) { this.nombreCiudadanoDestino = nombreCiudadanoDestino; }

    public String getCodTipo() { return codTipo; }
    public void setCodTipo(String codTipo) { this.codTipo = codTipo; }

    public String getDescripcionTipo() { return descripcionTipo; }
    public void setDescripcionTipo(String descripcionTipo) { this.descripcionTipo = descripcionTipo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getGradoMinimo() { return gradoMinimo; }
    public void setGradoMinimo(Integer gradoMinimo) { this.gradoMinimo = gradoMinimo; }

    public String getEsSimetrico() { return esSimetrico; }
    public void setEsSimetrico(String esSimetrico) { this.esSimetrico = esSimetrico; }

    public String getCodInverso() { return codInverso; }
    public void setCodInverso(String codInverso) { this.codInverso = codInverso; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public String getIdActaSustento() { return idActaSustento; }
    public void setIdActaSustento(String idActaSustento) { this.idActaSustento = idActaSustento; }

    public ActaSustentoDto getActaSustento() { return actaSustento; }
    public void setActaSustento(ActaSustentoDto actaSustento) { this.actaSustento = actaSustento; }

    public String getIdDocumentoSustento() { return idDocumentoSustento; }
    public void setIdDocumentoSustento(String idDocumentoSustento) { this.idDocumentoSustento = idDocumentoSustento; }

    public Double getNivelConfianza() { return nivelConfianza; }
    public void setNivelConfianza(Double nivelConfianza) { this.nivelConfianza = nivelConfianza; }

    public String getEstadoConfirmacion() { return estadoConfirmacion; }
    public void setEstadoConfirmacion(String estadoConfirmacion) { this.estadoConfirmacion = estadoConfirmacion; }

    public Boolean getRequiereValidacionManual() { return requiereValidacionManual; }
    public void setRequiereValidacionManual(Boolean requiereValidacionManual) { this.requiereValidacionManual = requiereValidacionManual; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}
