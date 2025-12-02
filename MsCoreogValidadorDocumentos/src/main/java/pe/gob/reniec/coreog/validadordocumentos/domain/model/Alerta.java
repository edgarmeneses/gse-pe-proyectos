package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa una alerta de verificación
 */
public class Alerta {
    private String codigo;
    private String descripcion;
    private String severidad;

    public Alerta() {
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

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }
}
