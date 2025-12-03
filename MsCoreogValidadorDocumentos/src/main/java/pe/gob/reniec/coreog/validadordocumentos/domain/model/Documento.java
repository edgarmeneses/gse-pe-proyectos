package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Entidad de dominio que representa un documento a validar
 */
public class Documento {
    private String documentoId;
    private String tipoDocumental;
    private String nombreArchivo;
    private String rutaGestorDocumental;
    private String hashSHA256;
    private String formatoDocumento;
    private Long tamanioBytes;
    private Boolean requiereValidacionIA;

    public Documento() {
    }

    public Documento(String documentoId, String tipoDocumental, String nombreArchivo, 
                     String rutaGestorDocumental, String hashSHA256, String formatoDocumento, 
                     Long tamanioBytes, Boolean requiereValidacionIA) {
        this.documentoId = documentoId;
        this.tipoDocumental = tipoDocumental;
        this.nombreArchivo = nombreArchivo;
        this.rutaGestorDocumental = rutaGestorDocumental;
        this.hashSHA256 = hashSHA256;
        this.formatoDocumento = formatoDocumento;
        this.tamanioBytes = tamanioBytes;
        this.requiereValidacionIA = requiereValidacionIA;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getTipoDocumental() {
        return tipoDocumental;
    }

    public void setTipoDocumental(String tipoDocumental) {
        this.tipoDocumental = tipoDocumental;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRutaGestorDocumental() {
        return rutaGestorDocumental;
    }

    public void setRutaGestorDocumental(String rutaGestorDocumental) {
        this.rutaGestorDocumental = rutaGestorDocumental;
    }

    public String getHashSHA256() {
        return hashSHA256;
    }

    public void setHashSHA256(String hashSHA256) {
        this.hashSHA256 = hashSHA256;
    }

    public String getFormatoDocumento() {
        return formatoDocumento;
    }

    public void setFormatoDocumento(String formatoDocumento) {
        this.formatoDocumento = formatoDocumento;
    }

    public Long getTamanioBytes() {
        return tamanioBytes;
    }

    public void setTamanioBytes(Long tamanioBytes) {
        this.tamanioBytes = tamanioBytes;
    }

    public Boolean getRequiereValidacionIA() {
        return requiereValidacionIA;
    }

    public void setRequiereValidacionIA(Boolean requiereValidacionIA) {
        this.requiereValidacionIA = requiereValidacionIA;
    }
}
