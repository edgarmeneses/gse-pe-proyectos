package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Prioridad de procesamiento de la solicitud
 * Afecta el orden y tiempo de procesamiento en el dominio
 */
public enum Prioridad {
    
    URGENTE("Procesamiento inmediato", 1),
    ALTA("Procesamiento prioritario", 2),
    MEDIA("Procesamiento normal", 3),
    BAJA("Procesamiento diferido", 4);
    
    private final String descripcion;
    private final int nivel;
    
    Prioridad(String descripcion, int nivel) {
        this.descripcion = descripcion;
        this.nivel = nivel;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public boolean esMayorQue(Prioridad otra) {
        return this.nivel < otra.nivel;
    }
    
    public static Prioridad fromString(String prioridad) {
        if (prioridad == null) {
            return MEDIA;
        }
        
        try {
            return Prioridad.valueOf(prioridad.toUpperCase());
        } catch (IllegalArgumentException e) {
            return MEDIA;
        }
    }
}
