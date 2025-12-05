package pe.gob.reniec.circunscripciones.domain.model;

public class Recomendacion {

    private String tipo;
    private Integer cantidad;
    private String descripcion;

    public Recomendacion() {
    }

    public Recomendacion(String tipo, Integer cantidad, String descripcion) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
