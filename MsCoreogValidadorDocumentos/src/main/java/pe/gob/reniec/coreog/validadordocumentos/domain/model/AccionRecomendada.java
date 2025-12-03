package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa una acción recomendada
 */
public class AccionRecomendada {
    private String tipo;
    private String descripcion;
    private String prioridad;

    public AccionRecomendada() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
