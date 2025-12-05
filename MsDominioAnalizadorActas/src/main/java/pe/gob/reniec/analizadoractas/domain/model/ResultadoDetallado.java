package pe.gob.reniec.analizadoractas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Value Object: Representa el resultado detallado del análisis de una acta específica
 */
public class ResultadoDetallado {

    private String actaId;
    private String numeroActa;
    private String tipoActa;
    private LocalDateTime fechaRegistro;
    private String oficinaRegistral;
    private Double scoreRiesgo;
    private String nivelRiesgo;
    private List<AlertaDetectada> alertasDetectadas;
    private String clasificacionIA;
    private List<String> recomendaciones;
    private String urlActaOriginal;

    public ResultadoDetallado() {
    }

    public ResultadoDetallado(String actaId, String numeroActa, String tipoActa,
                              LocalDateTime fechaRegistro, String oficinaRegistral, Double scoreRiesgo,
                              String nivelRiesgo, List<AlertaDetectada> alertasDetectadas,
                              String clasificacionIA, List<String> recomendaciones, String urlActaOriginal) {
        this.actaId = actaId;
        this.numeroActa = numeroActa;
        this.tipoActa = tipoActa;
        this.fechaRegistro = fechaRegistro;
        this.oficinaRegistral = oficinaRegistral;
        this.scoreRiesgo = scoreRiesgo;
        this.nivelRiesgo = nivelRiesgo;
        this.alertasDetectadas = alertasDetectadas;
        this.clasificacionIA = clasificacionIA;
        this.recomendaciones = recomendaciones;
        this.urlActaOriginal = urlActaOriginal;
    }

    public String getActaId() {
        return actaId;
    }

    public void setActaId(String actaId) {
        this.actaId = actaId;
    }

    public String getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(String numeroActa) {
        this.numeroActa = numeroActa;
    }

    public String getTipoActa() {
        return tipoActa;
    }

    public void setTipoActa(String tipoActa) {
        this.tipoActa = tipoActa;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(String oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }

    public Double getScoreRiesgo() {
        return scoreRiesgo;
    }

    public void setScoreRiesgo(Double scoreRiesgo) {
        this.scoreRiesgo = scoreRiesgo;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public List<AlertaDetectada> getAlertasDetectadas() {
        return alertasDetectadas;
    }

    public void setAlertasDetectadas(List<AlertaDetectada> alertasDetectadas) {
        this.alertasDetectadas = alertasDetectadas;
    }

    public String getClasificacionIA() {
        return clasificacionIA;
    }

    public void setClasificacionIA(String clasificacionIA) {
        this.clasificacionIA = clasificacionIA;
    }

    public List<String> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<String> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getUrlActaOriginal() {
        return urlActaOriginal;
    }

    public void setUrlActaOriginal(String urlActaOriginal) {
        this.urlActaOriginal = urlActaOriginal;
    }
}
