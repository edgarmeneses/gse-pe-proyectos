package pe.gob.reniec.dominioparentesco.domain.model;

/**
 * Enum - Estados posibles de un análisis de parentesco.
 * Representa el ciclo de vida del análisis.
 */
public enum EstadoAnalisis {
    
    SOLICITADO("Análisis solicitado, pendiente de iniciar"),
    EN_PROCESO("Análisis en ejecución"),
    COMPLETADO("Análisis completado exitosamente"),
    COMPLETADO_CON_OBSERVACIONES("Análisis completado pero requiere revisión manual"),
    FALLIDO("Análisis falló por error técnico o de datos"),
    CANCELADO("Análisis cancelado por el usuario");
    
    private final String descripcion;
    
    EstadoAnalisis(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean esEstadoFinal() {
        return this == COMPLETADO || 
               this == COMPLETADO_CON_OBSERVACIONES || 
               this == FALLIDO || 
               this == CANCELADO;
    }
    
    public boolean requiereRevisionManual() {
        return this == COMPLETADO_CON_OBSERVACIONES;
    }
    
    public boolean puedeTransicionarA(EstadoAnalisis nuevoEstado) {
        return switch (this) {
            case SOLICITADO -> nuevoEstado == EN_PROCESO || nuevoEstado == CANCELADO;
            case EN_PROCESO -> nuevoEstado == COMPLETADO || 
                              nuevoEstado == COMPLETADO_CON_OBSERVACIONES || 
                              nuevoEstado == FALLIDO ||
                              nuevoEstado == CANCELADO;
            case COMPLETADO, COMPLETADO_CON_OBSERVACIONES, FALLIDO, CANCELADO -> false;
        };
    }
}
