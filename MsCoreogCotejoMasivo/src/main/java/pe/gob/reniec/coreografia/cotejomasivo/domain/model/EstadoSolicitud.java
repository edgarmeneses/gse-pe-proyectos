package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Estado de una solicitud de cotejo masivo
 * Representa el ciclo de vida en el dominio de negocio
 */
public enum EstadoSolicitud {
    
    BORRADOR("Solicitud en edición"),
    REGISTRADA("Solicitud registrada, pendiente de procesamiento"),
    EN_PROCESO("Cotejo en ejecución"),
    COMPLETADA("Cotejo completado exitosamente"),
    CANCELADA("Solicitud cancelada"),
    RECHAZADA("Solicitud rechazada por validaciones de negocio");
    
    private final String descripcion;
    
    EstadoSolicitud(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean esEstadoFinal() {
        return this == COMPLETADA || this == CANCELADA || this == RECHAZADA;
    }
    
    public boolean esEstadoActivo() {
        return this == REGISTRADA || this == EN_PROCESO;
    }
}
