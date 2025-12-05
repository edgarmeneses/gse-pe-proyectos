package pe.gob.reniec.validadordocumentos.domain.model;

import java.util.List;

/**
 * Value Object que representa una observación detectada durante la evaluación de un documento.
 */
public class Observacion {

    private String codigo;
    private String descripcion;
    private String severidad;
    private List<String> evidencias;

    public Observacion() {
    }

    public Observacion(String codigo, String descripcion, String severidad, List<String> evidencias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.evidencias = evidencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public List<String> getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(List<String> evidencias) {
        this.evidencias = evidencias;
    }
}
