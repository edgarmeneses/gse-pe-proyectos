package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.util.List;

/**
 * Objeto de valor que representa una observación detectada en un documento
 */
public class Observacion {
    private String codigo;
    private String descripcion;
    private String severidad;
    private List<String> evidencias;

    public Observacion() {
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
