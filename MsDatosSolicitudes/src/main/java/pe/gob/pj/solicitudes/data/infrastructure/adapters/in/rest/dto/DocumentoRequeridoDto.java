package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class DocumentoRequeridoDto {
    private final String tipoDocumento;
    private final String descripcion;
    private final Boolean obligatorio;

    public DocumentoRequeridoDto(String tipoDocumento, String descripcion, Boolean obligatorio) {
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
        this.obligatorio = obligatorio;
    }

    public String tipoDocumento() { return tipoDocumento; }
    public String descripcion() { return descripcion; }
    public Boolean obligatorio() { return obligatorio; }
}
