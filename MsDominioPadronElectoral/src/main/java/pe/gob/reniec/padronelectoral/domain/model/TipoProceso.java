package pe.gob.reniec.padronelectoral.domain.model;

/**
 * Enum: Tipo de Proceso Electoral
 * Define los diferentes tipos de procesos electorales.
 */
public enum TipoProceso {
    ELECCIONES_GENERALES("Elecciones Generales"),
    ELECCIONES_REGIONALES("Elecciones Regionales"),
    ELECCIONES_MUNICIPALES("Elecciones Municipales"),
    REFERENDUM("Referéndum"),
    CONSULTA_POPULAR("Consulta Popular");

    private final String descripcion;

    TipoProceso(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoProceso fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de proceso no puede ser nulo o vacío");
        }
        
        for (TipoProceso tipo : values()) {
            if (tipo.name().equalsIgnoreCase(valor.trim()) || 
                tipo.descripcion.equalsIgnoreCase(valor.trim())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de proceso no válido: " + valor);
    }
}
