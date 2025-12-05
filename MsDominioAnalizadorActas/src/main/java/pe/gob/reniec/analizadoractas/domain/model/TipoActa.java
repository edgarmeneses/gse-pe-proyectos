package pe.gob.reniec.analizadoractas.domain.model;

/**
 * Value Object: Representa el tipo de acta registral
 */
public class TipoActa {

    private String codigo;
    private String descripcion;

    public TipoActa() {
    }

    public TipoActa(String codigo, String descripcion) {
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
