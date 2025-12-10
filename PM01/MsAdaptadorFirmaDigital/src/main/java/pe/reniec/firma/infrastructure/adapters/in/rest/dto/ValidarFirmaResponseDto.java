package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ValidarFirmaResponseDto {
    private String validacionId;
    private DocumentoDto documento;
    private ResultadoValidacionDto resultadoValidacion;
    private List<DetalleFirmaDto> detallesFirmas;
    private List<String> advertencias;
    private List<String> errores;
    private MetadataDto metadata;

    public ValidarFirmaResponseDto() {}

    public String getValidacionId() {
        return validacionId;
    }

    public void setValidacionId(String validacionId) {
        this.validacionId = validacionId;
    }

    public DocumentoDto getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDto documento) {
        this.documento = documento;
    }

    public ResultadoValidacionDto getResultadoValidacion() {
        return resultadoValidacion;
    }

    public void setResultadoValidacion(ResultadoValidacionDto resultadoValidacion) {
        this.resultadoValidacion = resultadoValidacion;
    }

    public List<DetalleFirmaDto> getDetallesFirmas() {
        return detallesFirmas;
    }

    public void setDetallesFirmas(List<DetalleFirmaDto> detallesFirmas) {
        this.detallesFirmas = detallesFirmas;
    }

    public List<String> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(List<String> advertencias) {
        this.advertencias = advertencias;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
