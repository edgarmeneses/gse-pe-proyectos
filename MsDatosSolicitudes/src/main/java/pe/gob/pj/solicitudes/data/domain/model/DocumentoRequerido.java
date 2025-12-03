package pe.gob.pj.solicitudes.data.domain.model;

public class DocumentoRequerido {
    
    private String tipoDocumento;
    private String descripcion;
    private Boolean obligatorio;

    public DocumentoRequerido() {
    }

    public DocumentoRequerido(String tipoDocumento, String descripcion, Boolean obligatorio) {
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
        this.obligatorio = obligatorio;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }
}
