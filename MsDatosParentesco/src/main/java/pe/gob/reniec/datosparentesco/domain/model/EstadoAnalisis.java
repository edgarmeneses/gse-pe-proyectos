package pe.gob.reniec.datosparentesco.domain.model;

/**
 * Enum que representa los estados posibles de un análisis de parentesco.
 * Refleja las transiciones de estado permitidas según reglas de negocio.
 */
public enum EstadoAnalisis {
    
    PENDIENTE("PENDIENTE", "Análisis pendiente de procesamiento"),
    EN_PROCESO("EN_PROCESO", "Análisis en curso"),
    COMPLETADO("COMPLETADO", "Análisis completado exitosamente"),
    VALIDADO("VALIDADO", "Análisis validado por técnico"),
    RECHAZADO("RECHAZADO", "Análisis rechazado"),
    CANCELADO("CANCELADO", "Análisis cancelado");
    
    private final String codigo;
    private final String descripcion;
    
    EstadoAnalisis(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Valida si se puede transicionar al estado destino.
     * Implementa las reglas de transición de estados.
     */
    public boolean puedeTransicionarA(EstadoAnalisis estadoDestino) {
        switch (this) {
            case PENDIENTE:
                return estadoDestino == EN_PROCESO || estadoDestino == CANCELADO;
            case EN_PROCESO:
                return estadoDestino == COMPLETADO || estadoDestino == RECHAZADO || estadoDestino == CANCELADO;
            case COMPLETADO:
                return estadoDestino == VALIDADO || estadoDestino == RECHAZADO;
            case VALIDADO:
            case RECHAZADO:
            case CANCELADO:
                return false; // Estados finales
            default:
                return false;
        }
    }
    
    public boolean esFinal() {
        return this == VALIDADO || this == RECHAZADO || this == CANCELADO;
    }
    
    public static EstadoAnalisis fromCodigo(String codigo) {
        for (EstadoAnalisis estado : values()) {
            if (estado.codigo.equals(codigo)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Estado de análisis inválido: " + codigo);
    }
}
