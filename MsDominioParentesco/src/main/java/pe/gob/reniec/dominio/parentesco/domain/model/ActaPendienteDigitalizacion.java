package pe.gob.reniec.dominio.parentesco.domain.model;

public class ActaPendienteDigitalizacion {
    private String tipoActa;
    private String referenciaActa;
    private String oficinaRegistral;
    private String observacion;

    public ActaPendienteDigitalizacion() {
    }

    public ActaPendienteDigitalizacion(String tipoActa, String referenciaActa, String oficinaRegistral,
                                      String observacion) {
        this.tipoActa = tipoActa;
        this.referenciaActa = referenciaActa;
        this.oficinaRegistral = oficinaRegistral;
        this.observacion = observacion;
    }

    public String getTipoActa() {
        return tipoActa;
    }

    public void setTipoActa(String tipoActa) {
        this.tipoActa = tipoActa;
    }

    public String getReferenciaActa() {
        return referenciaActa;
    }

    public void setReferenciaActa(String referenciaActa) {
        this.referenciaActa = referenciaActa;
    }

    public String getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(String oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
