package pe.gob.reniec.validadordocumentos.domain.model;

/**
 * Value Object que representa una acción recomendada resultado de la evaluación.
 */
public class AccionRecomendada {

    private String tipo;
    private String descripcion;
    private String prioridad;

    public AccionRecomendada() {
    }

    public AccionRecomendada(String tipo, String descripcion, String prioridad) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
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
