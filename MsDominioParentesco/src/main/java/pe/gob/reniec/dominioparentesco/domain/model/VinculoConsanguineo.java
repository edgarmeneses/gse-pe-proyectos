package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity - Representa un vínculo de consanguinidad encontrado en el análisis.
 */
public class VinculoConsanguineo {
    
    private final Long idRelacion;
    private final String idCiudadanoOrigen;
    private final String idCiudadanoDestino;
    private final String nombreCiudadanoDestino;
    private final String codTipo;
    private final String descripcionTipo;
    private final String categoria;
    private final Integer gradoMinimo;
    private final String esSimetrico;
    private final String codInverso;
    private final LocalDateTime fechaInicio;
    private final LocalDateTime fechaFin;
    private final String idActaSustento;
    private final ActaSustento actaSustento;
    private final String idDocumentoSustento;
    private final Double nivelConfianza;
    private final String estadoConfirmacion;
    private final Boolean requiereValidacionManual;
    private final String observacion;
    
    private VinculoConsanguineo(Builder builder) {
        this.idRelacion = builder.idRelacion;
        this.idCiudadanoOrigen = builder.idCiudadanoOrigen;
        this.idCiudadanoDestino = builder.idCiudadanoDestino;
        this.nombreCiudadanoDestino = builder.nombreCiudadanoDestino;
        this.codTipo = builder.codTipo;
        this.descripcionTipo = builder.descripcionTipo;
        this.categoria = builder.categoria;
        this.gradoMinimo = builder.gradoMinimo;
        this.esSimetrico = builder.esSimetrico;
        this.codInverso = builder.codInverso;
        this.fechaInicio = builder.fechaInicio;
        this.fechaFin = builder.fechaFin;
        this.idActaSustento = builder.idActaSustento;
        this.actaSustento = builder.actaSustento;
        this.idDocumentoSustento = builder.idDocumentoSustento;
        this.nivelConfianza = builder.nivelConfianza;
        this.estadoConfirmacion = builder.estadoConfirmacion;
        this.requiereValidacionManual = builder.requiereValidacionManual;
        this.observacion = builder.observacion;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public Long getIdRelacion() { return idRelacion; }
    public String getIdCiudadanoOrigen() { return idCiudadanoOrigen; }
    public String getIdCiudadanoDestino() { return idCiudadanoDestino; }
    public String getNombreCiudadanoDestino() { return nombreCiudadanoDestino; }
    public String getCodTipo() { return codTipo; }
    public String getDescripcionTipo() { return descripcionTipo; }
    public String getCategoria() { return categoria; }
    public Integer getGradoMinimo() { return gradoMinimo; }
    public String getEsSimetrico() { return esSimetrico; }
    public String getCodInverso() { return codInverso; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public String getIdActaSustento() { return idActaSustento; }
    public ActaSustento getActaSustento() { return actaSustento; }
    public String getIdDocumentoSustento() { return idDocumentoSustento; }
    public Double getNivelConfianza() { return nivelConfianza; }
    public String getEstadoConfirmacion() { return estadoConfirmacion; }
    public Boolean getRequiereValidacionManual() { return requiereValidacionManual; }
    public String getObservacion() { return observacion; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VinculoConsanguineo that = (VinculoConsanguineo) o;
        return Objects.equals(idRelacion, that.idRelacion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idRelacion);
    }
    
    public static class Builder {
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
        private ActaSustento actaSustento;
        private String idDocumentoSustento;
        private Double nivelConfianza;
        private String estadoConfirmacion;
        private Boolean requiereValidacionManual;
        private String observacion;
        
        public Builder idRelacion(Long idRelacion) { this.idRelacion = idRelacion; return this; }
        public Builder idCiudadanoOrigen(String idCiudadanoOrigen) { this.idCiudadanoOrigen = idCiudadanoOrigen; return this; }
        public Builder idCiudadanoDestino(String idCiudadanoDestino) { this.idCiudadanoDestino = idCiudadanoDestino; return this; }
        public Builder nombreCiudadanoDestino(String nombreCiudadanoDestino) { this.nombreCiudadanoDestino = nombreCiudadanoDestino; return this; }
        public Builder codTipo(String codTipo) { this.codTipo = codTipo; return this; }
        public Builder descripcionTipo(String descripcionTipo) { this.descripcionTipo = descripcionTipo; return this; }
        public Builder categoria(String categoria) { this.categoria = categoria; return this; }
        public Builder gradoMinimo(Integer gradoMinimo) { this.gradoMinimo = gradoMinimo; return this; }
        public Builder esSimetrico(String esSimetrico) { this.esSimetrico = esSimetrico; return this; }
        public Builder codInverso(String codInverso) { this.codInverso = codInverso; return this; }
        public Builder fechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; return this; }
        public Builder fechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; return this; }
        public Builder idActaSustento(String idActaSustento) { this.idActaSustento = idActaSustento; return this; }
        public Builder actaSustento(ActaSustento actaSustento) { this.actaSustento = actaSustento; return this; }
        public Builder idDocumentoSustento(String idDocumentoSustento) { this.idDocumentoSustento = idDocumentoSustento; return this; }
        public Builder nivelConfianza(Double nivelConfianza) { this.nivelConfianza = nivelConfianza; return this; }
        public Builder estadoConfirmacion(String estadoConfirmacion) { this.estadoConfirmacion = estadoConfirmacion; return this; }
        public Builder requiereValidacionManual(Boolean requiereValidacionManual) { this.requiereValidacionManual = requiereValidacionManual; return this; }
        public Builder observacion(String observacion) { this.observacion = observacion; return this; }
        
        public VinculoConsanguineo build() {
            return new VinculoConsanguineo(this);
        }
    }
}
