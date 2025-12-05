package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO que representa una acción recomendada en la capa REST.
 */
public class AccionRecomendadaDto {

    private String tipo;
    private String descripcion;
    private String prioridad;

    public AccionRecomendadaDto() {
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
