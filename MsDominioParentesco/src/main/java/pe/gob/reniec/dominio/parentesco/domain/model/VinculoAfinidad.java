package pe.gob.reniec.dominio.parentesco.domain.model;

public class VinculoAfinidad {
    private String idVinculoPosible;
    private String idCiudadanoRelacionado;
    private String nombreCompleto;
    private String tipoParentesco;
    private String descripcionParentesco;
    private Integer gradoAfinidad;
    private ConyugeIntermedio conyugeIntermedio;
    private ActaSustento actaSustento;
    private Double nivelConfianza;
    private String estadoConfirmacion;
    private Boolean requiereValidacionManual;
    private String observaciones;

    public VinculoAfinidad() {
    }

    public VinculoAfinidad(String idVinculoPosible, String idCiudadanoRelacionado, String nombreCompleto,
                          String tipoParentesco, String descripcionParentesco, Integer gradoAfinidad,
                          ConyugeIntermedio conyugeIntermedio, ActaSustento actaSustento, Double nivelConfianza,
                          String estadoConfirmacion, Boolean requiereValidacionManual, String observaciones) {
        this.idVinculoPosible = idVinculoPosible;
        this.idCiudadanoRelacionado = idCiudadanoRelacionado;
        this.nombreCompleto = nombreCompleto;
        this.tipoParentesco = tipoParentesco;
        this.descripcionParentesco = descripcionParentesco;
        this.gradoAfinidad = gradoAfinidad;
        this.conyugeIntermedio = conyugeIntermedio;
        this.actaSustento = actaSustento;
        this.nivelConfianza = nivelConfianza;
        this.estadoConfirmacion = estadoConfirmacion;
        this.requiereValidacionManual = requiereValidacionManual;
        this.observaciones = observaciones;
    }

    public String getIdVinculoPosible() {
        return idVinculoPosible;
    }

    public void setIdVinculoPosible(String idVinculoPosible) {
        this.idVinculoPosible = idVinculoPosible;
    }

    public String getIdCiudadanoRelacionado() {
        return idCiudadanoRelacionado;
    }

    public void setIdCiudadanoRelacionado(String idCiudadanoRelacionado) {
        this.idCiudadanoRelacionado = idCiudadanoRelacionado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    public Integer getGradoAfinidad() {
        return gradoAfinidad;
    }

    public void setGradoAfinidad(Integer gradoAfinidad) {
        this.gradoAfinidad = gradoAfinidad;
    }

    public ConyugeIntermedio getConyugeIntermedio() {
        return conyugeIntermedio;
    }

    public void setConyugeIntermedio(ConyugeIntermedio conyugeIntermedio) {
        this.conyugeIntermedio = conyugeIntermedio;
    }

    public ActaSustento getActaSustento() {
        return actaSustento;
    }

    public void setActaSustento(ActaSustento actaSustento) {
        this.actaSustento = actaSustento;
    }

    public Double getNivelConfianza() {
        return nivelConfianza;
    }

    public void setNivelConfianza(Double nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }

    public String getEstadoConfirmacion() {
        return estadoConfirmacion;
    }

    public void setEstadoConfirmacion(String estadoConfirmacion) {
        this.estadoConfirmacion = estadoConfirmacion;
    }

    public Boolean getRequiereValidacionManual() {
        return requiereValidacionManual;
    }

    public void setRequiereValidacionManual(Boolean requiereValidacionManual) {
        this.requiereValidacionManual = requiereValidacionManual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
