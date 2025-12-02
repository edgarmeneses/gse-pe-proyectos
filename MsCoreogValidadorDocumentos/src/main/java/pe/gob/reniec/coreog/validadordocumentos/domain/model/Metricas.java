package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa métricas técnicas de evaluación
 */
public class Metricas {
    private Double calidadImagen;
    private Double legibilidadTexto;
    private Double integridadEstructura;
    private Double confianzaOCR;

    public Metricas() {
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
