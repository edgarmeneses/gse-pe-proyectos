package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Enum: Representa los tipos de certificados digitales del DNIe.
 */
public enum TipoCertificado {
    AUTENTICACION("Certificado de Autenticación"),
    FIRMA("Certificado de Firma Digital"),
    CIFRADO("Certificado de Cifrado");
    
    private final String descripcion;
    
    TipoCertificado(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static TipoCertificado fromString(String tipo) {
        if (tipo == null) {
            return null;
        }
        for (TipoCertificado t : values()) {
            if (t.name().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Tipo de certificado inválido: " + tipo);
    }
}
