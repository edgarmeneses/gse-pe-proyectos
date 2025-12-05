package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Resultado detallado del análisis de una acta
 */
public class ResultadoDetalladoDto {

    private String actaId;
    private String numeroActa;
    private String tipoActa;
    private String fechaRegistro;
    private String oficinaRegistral;
    private Double scoreRiesgo;
    private String nivelRiesgo;
    private List<AlertaDetectadaDto> alertasDetectadas;
    private String clasificacionIA;
    private List<String> recomendaciones;
    private String urlActaOriginal;

    public ResultadoDetalladoDto() {
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
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

    public List<AlertaDetectadaDto> getAlertasDetectadas() {
        return alertasDetectadas;
    }

    public void setAlertasDetectadas(List<AlertaDetectadaDto> alertasDetectadas) {
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
