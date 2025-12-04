package pe.gob.reniec.datosparentesco.domain.model;

/**
 * Enum que representa los tipos de vínculos de parentesco.
 */
public enum TipoVinculo {
    
    PADRE("PADRE", "Relación padre-hijo"),
    MADRE("MADRE", "Relación madre-hijo"),
    HIJO("HIJO", "Relación hijo-padre/madre"),
    HERMANO("HERMANO", "Relación entre hermanos"),
    CONYUGE("CONYUGE", "Relación conyugal"),
    ABUELO("ABUELO", "Relación abuelo-nieto"),
    NIETO("NIETO", "Relación nieto-abuelo"),
    TIO("TIO", "Relación tío-sobrino"),
    SOBRINO("SOBRINO", "Relación sobrino-tío");
    
    private final String codigo;
    private final String descripcion;
    
    TipoVinculo(String codigo, String descripcion) {
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
     * Retorna el tipo de vínculo inverso.
     * Ejemplo: PADRE -> HIJO, HIJO -> PADRE
     */
    public TipoVinculo obtenerVinculoInverso() {
        switch (this) {
            case PADRE:
                return HIJO;
            case MADRE:
                return HIJO;
            case HIJO:
                return PADRE; // Simplificado, podría ser PADRE o MADRE
            case HERMANO:
                return HERMANO;
            case CONYUGE:
                return CONYUGE;
            case ABUELO:
                return NIETO;
            case NIETO:
                return ABUELO;
            case TIO:
                return SOBRINO;
            case SOBRINO:
                return TIO;
            default:
                throw new IllegalStateException("Vínculo sin inverso definido: " + this);
        }
    }
    
    public static TipoVinculo fromCodigo(String codigo) {
        for (TipoVinculo tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de vínculo inválido: " + codigo);
    }
}
