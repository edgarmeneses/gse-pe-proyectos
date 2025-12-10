package pe.gob.reniec.padronelectoral.domain.model;

/**
 * Enum: Tipo de Verificación de Domicilio
 * Define los diferentes tipos de verificaciones de domicilio.
 */
public enum TipoVerificacion {
    PRESENCIAL("Verificación Presencial"),
    DOCUMENTAL("Verificación Documental"),
    VIRTUAL("Verificación Virtual"),
    MIXTA("Verificación Mixta");

    private final String descripcion;

    TipoVerificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoVerificacion fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return DOCUMENTAL; // Valor por defecto
        }
        
        for (TipoVerificacion tipo : values()) {
            if (tipo.name().equalsIgnoreCase(valor.trim()) || 
                tipo.descripcion.equalsIgnoreCase(valor.trim())) {
                return tipo;
            }
        }
        return DOCUMENTAL; // Valor por defecto si no coincide
    }
}
