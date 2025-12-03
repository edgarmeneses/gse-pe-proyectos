package pe.gob.reniec.gse.registradores.domain.model;

/**
 * Enum: Estado del Periodo
 * Define los posibles estados de un periodo de asignación.
 */
public enum EstadoPeriodo {
    
    ACTIVO("A", "Activo"),
    CERRADO("C", "Cerrado"),
    CANCELADO("X", "Cancelado");
    
    private final String codigo;
    private final String descripcion;
    
    EstadoPeriodo(String codigo, String descripcion) {
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
     * Obtiene un estado por su código.
     */
    public static EstadoPeriodo desdeCodigo(String codigo) {
        for (EstadoPeriodo estado : values()) {
            if (estado.codigo.equals(codigo)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado de periodo no válido: " + codigo);
    }
}
