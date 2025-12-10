package pe.gob.reniec.padronelectoral.domain.model;

/**
 * Enum: Tipo de Padrón Electoral
 * Define los diferentes tipos de padrones que pueden existir.
 */
public enum TipoPadron {
    INICIAL("Inicial"),
    PRELIMINAR("Preliminar"),
    FINAL("Final"),
    COMPLEMENTARIO("Complementario");

    private final String descripcion;

    TipoPadron(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoPadron fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de padrón no puede ser nulo o vacío");
        }
        
        for (TipoPadron tipo : values()) {
            if (tipo.name().equalsIgnoreCase(valor.trim()) || 
                tipo.descripcion.equalsIgnoreCase(valor.trim())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de padrón no válido: " + valor);
    }
}
