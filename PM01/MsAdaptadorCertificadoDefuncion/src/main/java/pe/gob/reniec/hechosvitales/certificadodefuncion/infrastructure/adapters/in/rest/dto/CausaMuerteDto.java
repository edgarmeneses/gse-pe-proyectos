package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Causa de Muerte
 */
public class CausaMuerteDto {

    private String tipoCausa;
    private String coEnfermedad;
    private String deEnfermedad;
    private String tiempoEvolucion;

    public CausaMuerteDto() {
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
