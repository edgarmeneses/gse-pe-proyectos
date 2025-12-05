package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO que representa las métricas técnicas en la capa REST.
 */
public class MetricasDto {

    private Double calidadImagen;
    private Double legibilidadTexto;
    private Double integridadEstructura;
    private Double confianzaOCR;

    public MetricasDto() {
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
