package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Enum: Representa el estado civil de una persona.
 */
public enum EstadoCivil {
    SOLTERO("Soltero(a)"),
    CASADO("Casado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUDO("Viudo(a)"),
    CONVIVIENTE("Conviviente");
    
    private final String descripcion;
    
    EstadoCivil(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static EstadoCivil fromString(String estado) {
        if (estado == null) {
            return null;
        }
        for (EstadoCivil e : values()) {
            if (e.name().equalsIgnoreCase(estado)) {
                return e;
            }
        }
        return null; // Puede ser opcional
    }
}
