package pe.gob.reniec.protecciondocumentos.domain.model;

import java.util.List;

public class Destinatario {
    private String destinatarioId;
    private String tipo;
    private String nivelAcceso;
    private List<String> permisos;

    public Destinatario() {
    }

    public Destinatario(String destinatarioId, String tipo, String nivelAcceso, List<String> permisos) {
        this.destinatarioId = destinatarioId;
        this.tipo = tipo;
        this.nivelAcceso = nivelAcceso;
        this.permisos = permisos;
    }

    public String getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(String destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }
}
