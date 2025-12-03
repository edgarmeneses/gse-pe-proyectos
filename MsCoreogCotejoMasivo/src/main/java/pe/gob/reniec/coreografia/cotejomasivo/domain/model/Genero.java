package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Tipo de género en el dominio
 */
public enum Genero {
    
    MASCULINO("Masculino"),
    FEMENINO("Femenino");
    
    private final String descripcion;
    
    Genero(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static Genero fromString(String genero) {
        if (genero == null) {
            return null;
        }
        
        try {
            return Genero.valueOf(genero.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
