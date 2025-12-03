package pe.gob.reniec.gse.registradores.domain.model;

/**
 * Enum: Estado del Registrador
 * Define los posibles estados de un registrador en el sistema.
 */
public enum EstadoRegistrador {
    
    ACTIVO("01", "Activo"),
    INACTIVO("02", "Inactivo"),
    SUSPENDIDO("03", "Suspendido");
    
    private final String codigo;
    private final String descripcion;
    
    EstadoRegistrador(String codigo, String descripcion) {
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
    public static EstadoRegistrador desdeCodigo(String codigo) {
        for (EstadoRegistrador estado : values()) {
            if (estado.codigo.equals(codigo)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado no válido: " + codigo);
    }
}
