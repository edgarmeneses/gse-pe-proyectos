package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa un acta pendiente de digitalización.
 */
public class ActaPendienteDigitalizacion {
    
    private final String tipoActa;
    private final String referenciaActa;
    private final String lugarActa;
    private final String observacion;
    
    public ActaPendienteDigitalizacion(String tipoActa, String referenciaActa,
                                      String lugarActa, String observacion) {
        this.tipoActa = Objects.requireNonNull(tipoActa, "El tipo de acta no puede ser nulo");
        this.referenciaActa = Objects.requireNonNull(referenciaActa, "La referencia no puede ser nula");
        this.lugarActa = Objects.requireNonNull(lugarActa, "El lugar no puede ser nulo");
        this.observacion = observacion;
    }
    
    public String getTipoActa() { return tipoActa; }
    public String getReferenciaActa() { return referenciaActa; }
    public String getLugarActa() { return lugarActa; }
    public String getObservacion() { return observacion; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActaPendienteDigitalizacion that = (ActaPendienteDigitalizacion) o;
        return Objects.equals(referenciaActa, that.referenciaActa);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(referenciaActa);
    }
    
    @Override
    public String toString() {
        return "ActaPendienteDigitalizacion{" +
                "tipoActa='" + tipoActa + '\'' +
                ", referenciaActa='" + referenciaActa + '\'' +
                ", lugarActa='" + lugarActa + '\'' +
                '}';
    }
}
