package pe.gob.reniec.validadordocumentos.domain.model;

/**
 * Value Object que representa las métricas técnicas de evaluación de un documento.
 */
public class Metricas {

    private Double calidadImagen;
    private Double legibilidadTexto;
    private Double integridadEstructura;
    private Double confianzaOCR;

    public Metricas() {
    }

    public Metricas(Double calidadImagen, Double legibilidadTexto, Double integridadEstructura, Double confianzaOCR) {
        this.calidadImagen = calidadImagen;
        this.legibilidadTexto = legibilidadTexto;
        this.integridadEstructura = integridadEstructura;
        this.confianzaOCR = confianzaOCR;
    }

    public Double getCalidadImagen() {
        return calidadImagen;
    }

    public void setCalidadImagen(Double calidadImagen) {
        this.calidadImagen = calidadImagen;
    }

    public Double getLegibilidadTexto() {
        return legibilidadTexto;
    }

    public void setLegibilidadTexto(Double legibilidadTexto) {
        this.legibilidadTexto = legibilidadTexto;
    }

    public Double getIntegridadEstructura() {
        return integridadEstructura;
    }

    public void setIntegridadEstructura(Double integridadEstructura) {
        this.integridadEstructura = integridadEstructura;
    }

    public Double getConfianzaOCR() {
        return confianzaOCR;
    }

    public void setConfianzaOCR(Double confianzaOCR) {
        this.confianzaOCR = confianzaOCR;
    }
}
