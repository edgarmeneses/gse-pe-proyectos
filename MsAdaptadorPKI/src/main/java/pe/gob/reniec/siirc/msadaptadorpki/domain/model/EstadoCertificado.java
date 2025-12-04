package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Enum: Representa los estados posibles de un certificado digital.
 */
public enum EstadoCertificado {
    PENDIENTE("Certificado pendiente de emisión"),
    VIGENTE("Certificado vigente y activo"),
    REVOCADO("Certificado revocado"),
    EXPIRADO("Certificado expirado");
    
    private final String descripcion;
    
    EstadoCertificado(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static EstadoCertificado fromString(String estado) {
        if (estado == null) {
            return null;
        }
        for (EstadoCertificado e : values()) {
            if (e.name().equalsIgnoreCase(estado)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado de certificado inválido: " + estado);
    }
}
