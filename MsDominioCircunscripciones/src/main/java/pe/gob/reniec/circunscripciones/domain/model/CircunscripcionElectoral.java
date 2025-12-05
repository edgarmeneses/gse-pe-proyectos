package pe.gob.reniec.circunscripciones.domain.model;

public class CircunscripcionElectoral {

    private String tipo;
    private String codigo;
    private String nombre;

    public CircunscripcionElectoral() {
    }

    public CircunscripcionElectoral(String tipo, String codigo, String nombre) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
