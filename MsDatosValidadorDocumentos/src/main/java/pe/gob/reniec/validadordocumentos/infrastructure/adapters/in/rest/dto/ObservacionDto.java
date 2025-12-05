package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO que representa una observación en la capa REST.
 */
public class ObservacionDto {

    private String codigo;
    private String descripcion;
    private String severidad;
    private List<String> evidencias;

    public ObservacionDto() {
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
