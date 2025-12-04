package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Enum: Representa los tipos de documento de identidad.
 */
public enum TipoDocumento {
    DNI("Documento Nacional de Identidad"),
    CE("Carnet de Extranjería"),
    PASAPORTE("Pasaporte");
    
    private final String descripcion;
    
    TipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static TipoDocumento fromString(String tipo) {
        if (tipo == null) {
            return DNI; // Default
        }
        for (TipoDocumento t : values()) {
            if (t.name().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        return DNI; // Default si no coincide
    }
}
