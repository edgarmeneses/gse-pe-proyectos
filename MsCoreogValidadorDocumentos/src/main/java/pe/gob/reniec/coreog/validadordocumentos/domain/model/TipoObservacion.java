package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa un tipo de observación
 */
public class TipoObservacion {
    private String codigo;
    private String descripcion;

    public TipoObservacion() {
    }

    public TipoObservacion(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
