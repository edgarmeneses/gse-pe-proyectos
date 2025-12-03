package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Value Object que representa el tipo de relación de parentesco.
 */
public class TipoParentesco {
    private final String codigo;
    private final String descripcion;
    private final Boolean esSimetrico;

    public TipoParentesco(String codigo, String descripcion, Boolean esSimetrico) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código del tipo de parentesco es obligatorio");
        }
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.esSimetrico = esSimetrico != null ? esSimetrico : false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getEsSimetrico() {
        return esSimetrico;
    }

    /**
     * Verifica si este tipo de parentesco es simétrico (ej: hermano-hermano).
     */
    public boolean esSimetrico() {
        return esSimetrico != null && esSimetrico;
    }
}
