package pe.gob.reniec.circunscripciones.domain.model;

public class Alerta {

    private String tipo;
    private String ubigeo;
    private String descripcion;
    private String severidad;

    public Alerta() {
    }

    public Alerta(String tipo, String ubigeo, String descripcion, String severidad) {
        this.tipo = tipo;
        this.ubigeo = ubigeo;
        this.descripcion = descripcion;
        this.severidad = severidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
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
