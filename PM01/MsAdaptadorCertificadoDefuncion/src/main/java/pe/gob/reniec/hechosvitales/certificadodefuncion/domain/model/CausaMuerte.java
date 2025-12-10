package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model;

/**
 * Value Object: Causa de Muerte
 */
public class CausaMuerte {

    private String tipoCausa;
    private String coEnfermedad;
    private String deEnfermedad;
    private String tiempoEvolucion;

    public CausaMuerte() {
    }

    public CausaMuerte(String tipoCausa, String coEnfermedad, String deEnfermedad, String tiempoEvolucion) {
        this.tipoCausa = tipoCausa;
        this.coEnfermedad = coEnfermedad;
        this.deEnfermedad = deEnfermedad;
        this.tiempoEvolucion = tiempoEvolucion;
    }

    public String getTipoCausa() {
        return tipoCausa;
    }

    public void setTipoCausa(String tipoCausa) {
        this.tipoCausa = tipoCausa;
    }

    public String getCoEnfermedad() {
        return coEnfermedad;
    }

    public void setCoEnfermedad(String coEnfermedad) {
        this.coEnfermedad = coEnfermedad;
    }

    public String getDeEnfermedad() {
        return deEnfermedad;
    }

    public void setDeEnfermedad(String deEnfermedad) {
        this.deEnfermedad = deEnfermedad;
    }

    public String getTiempoEvolucion() {
        return tiempoEvolucion;
    }

    public void setTiempoEvolucion(String tiempoEvolucion) {
        this.tiempoEvolucion = tiempoEvolucion;
    }
}
