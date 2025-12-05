package pe.gob.reniec.circunscripciones.domain.model;

import java.time.LocalDate;
import java.util.List;

public class InformeFinal {

    private String informeId;
    private String cronogramaId;
    private String tipoInforme;
    private LocalDate fechaGeneracion;
    private CircunscripcionInforme circunscripcion;
    private EstadisticasInforme estadisticas;
    private List<Recomendacion> recomendaciones;
    private DocumentoGenerado documentoGenerado;
    private String estadoInforme;
    private Boolean requiereAprobacion;
    private String proximoPaso;

    public InformeFinal() {
    }

    public InformeFinal(String informeId, String cronogramaId, String tipoInforme,
                       LocalDate fechaGeneracion, CircunscripcionInforme circunscripcion,
                       EstadisticasInforme estadisticas, List<Recomendacion> recomendaciones,
                       DocumentoGenerado documentoGenerado, String estadoInforme,
                       Boolean requiereAprobacion, String proximoPaso) {
        this.informeId = informeId;
        this.cronogramaId = cronogramaId;
        this.tipoInforme = tipoInforme;
        this.fechaGeneracion = fechaGeneracion;
        this.circunscripcion = circunscripcion;
        this.estadisticas = estadisticas;
        this.recomendaciones = recomendaciones;
        this.documentoGenerado = documentoGenerado;
        this.estadoInforme = estadoInforme;
        this.requiereAprobacion = requiereAprobacion;
        this.proximoPaso = proximoPaso;
    }

    public String getInformeId() {
        return informeId;
    }

    public void setInformeId(String informeId) {
        this.informeId = informeId;
    }

    public String getCronogramaId() {
        return cronogramaId;
    }

    public void setCronogramaId(String cronogramaId) {
        this.cronogramaId = cronogramaId;
    }

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public CircunscripcionInforme getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(CircunscripcionInforme circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public EstadisticasInforme getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(EstadisticasInforme estadisticas) {
        this.estadisticas = estadisticas;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public DocumentoGenerado getDocumentoGenerado() {
        return documentoGenerado;
    }

    public void setDocumentoGenerado(DocumentoGenerado documentoGenerado) {
        this.documentoGenerado = documentoGenerado;
    }

    public String getEstadoInforme() {
        return estadoInforme;
    }

    public void setEstadoInforme(String estadoInforme) {
        this.estadoInforme = estadoInforme;
    }

    public Boolean getRequiereAprobacion() {
        return requiereAprobacion;
    }

    public void setRequiereAprobacion(Boolean requiereAprobacion) {
        this.requiereAprobacion = requiereAprobacion;
    }

    public String getProximoPaso() {
        return proximoPaso;
    }

    public void setProximoPaso(String proximoPaso) {
        this.proximoPaso = proximoPaso;
    }
}
