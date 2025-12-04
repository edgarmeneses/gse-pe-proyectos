package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para actas pendientes de digitalización.
 */
public class ActaPendienteDigitalizacionDto {
    private String tipoActa;
    private String referenciaActa;
    private String lugarActa;
    private String observacion;

    public ActaPendienteDigitalizacionDto() {}

    public String getTipoActa() { return tipoActa; }
    public void setTipoActa(String tipoActa) { this.tipoActa = tipoActa; }

    public String getReferenciaActa() { return referenciaActa; }
    public void setReferenciaActa(String referenciaActa) { this.referenciaActa = referenciaActa; }

    public String getLugarActa() { return lugarActa; }
    public void setLugarActa(String lugarActa) { this.lugarActa = lugarActa; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}
