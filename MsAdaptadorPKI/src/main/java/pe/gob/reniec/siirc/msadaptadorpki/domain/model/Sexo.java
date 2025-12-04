package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Enum: Representa el sexo biológico de una persona.
 */
public enum Sexo {
    MASCULINO("M", "Masculino"),
    FEMENINO("F", "Femenino");
    
    private final String codigo;
    private final String descripcion;
    
    Sexo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public static Sexo fromString(String sexo) {
        if (sexo == null) {
            return null;
        }
        for (Sexo s : values()) {
            if (s.name().equalsIgnoreCase(sexo) || s.codigo.equalsIgnoreCase(sexo)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sexo inválido: " + sexo);
    }
}
