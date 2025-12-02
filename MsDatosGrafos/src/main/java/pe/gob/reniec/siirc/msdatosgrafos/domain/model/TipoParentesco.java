package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Value Object que representa el tipo de parentesco entre dos ciudadanos
 */
public class TipoParentesco {
    private final String codigo;
    private final String descripcion;
    private final Boolean esSimetrico;

    public TipoParentesco(String codigo, String descripcion, Boolean esSimetrico) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.esSimetrico = esSimetrico;
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
}
