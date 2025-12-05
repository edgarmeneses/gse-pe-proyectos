package pe.gob.reniec.circunscripciones.domain.model;

public class CircunscripcionInforme {

    private String tipo;
    private String ubigeo;
    private String nombre;

    public CircunscripcionInforme() {
    }

    public CircunscripcionInforme(String tipo, String ubigeo, String nombre) {
        this.tipo = tipo;
        this.ubigeo = ubigeo;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
