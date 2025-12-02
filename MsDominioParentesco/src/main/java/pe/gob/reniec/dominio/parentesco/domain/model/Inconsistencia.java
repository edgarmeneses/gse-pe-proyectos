package pe.gob.reniec.dominio.parentesco.domain.model;

import java.util.List;

public class Inconsistencia {
    private String tipo;
    private String descripcion;
    private List<String> ciudadanosInvolucrados;
    private String severidad;
    private String accionRecomendada;

    public Inconsistencia() {
    }

    public Inconsistencia(String tipo, String descripcion, List<String> ciudadanosInvolucrados,
                         String severidad, String accionRecomendada) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ciudadanosInvolucrados = ciudadanosInvolucrados;
        this.severidad = severidad;
        this.accionRecomendada = accionRecomendada;
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

    public List<String> getCiudadanosInvolucrados() {
        return ciudadanosInvolucrados;
    }

    public void setCiudadanosInvolucrados(List<String> ciudadanosInvolucrados) {
        this.ciudadanosInvolucrados = ciudadanosInvolucrados;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getAccionRecomendada() {
        return accionRecomendada;
    }

    public void setAccionRecomendada(String accionRecomendada) {
        this.accionRecomendada = accionRecomendada;
    }
}
