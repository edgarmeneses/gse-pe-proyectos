package pe.reniec.firma.domain.model;

import java.util.List;

public class ProcesoValidacion {
    private String validacionId;
    private Documento documento;
    private ResultadoValidacion resultadoValidacion;
    private List<DetalleFirma> detallesFirmas;
    private List<String> advertencias;
    private List<String> errores;
    private Metadata metadata;

    public ProcesoValidacion() {}

    public String getValidacionId() {
        return validacionId;
    }

    public void setValidacionId(String validacionId) {
        this.validacionId = validacionId;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public ResultadoValidacion getResultadoValidacion() {
        return resultadoValidacion;
    }

    public void setResultadoValidacion(ResultadoValidacion resultadoValidacion) {
        this.resultadoValidacion = resultadoValidacion;
    }

    public List<DetalleFirma> getDetallesFirmas() {
        return detallesFirmas;
    }

    public void setDetallesFirmas(List<DetalleFirma> detallesFirmas) {
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

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
