package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa el resultado de verificación de firma
 */
public class ResultadoVerificacion {
    private String estadoFirma;
    private Boolean esFirmaValida;
    private String detalleEstado;
    private String fuenteValidacion;
    private Boolean requiereRevisionManual;

    public ResultadoVerificacion() {
    }

    public String getEstadoFirma() {
        return estadoFirma;
    }

    public void setEstadoFirma(String estadoFirma) {
        this.estadoFirma = estadoFirma;
    }

    public Boolean getEsFirmaValida() {
        return esFirmaValida;
    }

    public void setEsFirmaValida(Boolean esFirmaValida) {
        this.esFirmaValida = esFirmaValida;
    }

    public String getDetalleEstado() {
        return detalleEstado;
    }

    public void setDetalleEstado(String detalleEstado) {
        this.detalleEstado = detalleEstado;
    }

    public String getFuenteValidacion() {
        return fuenteValidacion;
    }

    public void setFuenteValidacion(String fuenteValidacion) {
        this.fuenteValidacion = fuenteValidacion;
    }

    public Boolean getRequiereRevisionManual() {
        return requiereRevisionManual;
    }

    public void setRequiereRevisionManual(Boolean requiereRevisionManual) {
        this.requiereRevisionManual = requiereRevisionManual;
    }
}
