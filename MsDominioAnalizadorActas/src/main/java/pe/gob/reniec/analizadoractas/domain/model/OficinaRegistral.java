package pe.gob.reniec.analizadoractas.domain.model;

/**
 * Value Object: Representa una oficina registral de RENIEC
 */
public class OficinaRegistral {

    private String codigo;
    private String nombre;

    public OficinaRegistral() {
    }

    public OficinaRegistral(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
