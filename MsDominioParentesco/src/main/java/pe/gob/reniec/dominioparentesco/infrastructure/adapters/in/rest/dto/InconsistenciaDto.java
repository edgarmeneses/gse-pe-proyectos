package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para inconsistencias detectadas en el análisis.
 */
public class InconsistenciaDto {
    private String tipo;
    private String descripcion;
    private List<String> ciudadanosInvolucrados;
    private String severidad;
    private String accionRecomendada;

    public InconsistenciaDto() {}

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<String> getCiudadanosInvolucrados() { return ciudadanosInvolucrados; }
    public void setCiudadanosInvolucrados(List<String> ciudadanosInvolucrados) { this.ciudadanosInvolucrados = ciudadanosInvolucrados; }

    public String getSeveridad() { return severidad; }
    public void setSeveridad(String severidad) { this.severidad = severidad; }

    public String getAccionRecomendada() { return accionRecomendada; }
    public void setAccionRecomendada(String accionRecomendada) { this.accionRecomendada = accionRecomendada; }
}
