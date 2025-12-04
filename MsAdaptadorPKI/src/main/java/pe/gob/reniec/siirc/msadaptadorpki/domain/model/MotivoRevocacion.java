package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Enum: Representa los motivos válidos para revocar un certificado.
 */
public enum MotivoRevocacion {
    COMPROMISO_CLAVE("Compromiso de la clave privada"),
    CAMBIO_AFILIACION("Cambio en la afiliación del titular"),
    SUSTITUCION("Sustitución del certificado"),
    CESACION_OPERACION("Cesación de operación"),
    PERDIDA_DNI("Pérdida del DNI electrónico"),
    ROBO_DNI("Robo del DNI electrónico"),
    SOLICITUD_TITULAR("Solicitud del titular"),
    DATOS_INCORRECTOS("Datos incorrectos en el certificado");
    
    private final String descripcion;
    
    MotivoRevocacion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static MotivoRevocacion fromString(String motivo) {
        if (motivo == null) {
            return null;
        }
        for (MotivoRevocacion m : values()) {
            if (m.name().equalsIgnoreCase(motivo)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Motivo de revocación inválido: " + motivo);
    }
}
