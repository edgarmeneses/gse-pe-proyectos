package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Value Object que representa los documentos que sustentan un vínculo de parentesco.
 */
public class Sustento {
    private final String idActaSustento;
    private final String idDocumentoSustento;

    public Sustento(String idActaSustento, String idDocumentoSustento) {
        this.idActaSustento = idActaSustento;
        this.idDocumentoSustento = idDocumentoSustento;
    }

    public String getIdActaSustento() {
        return idActaSustento;
    }

    public String getIdDocumentoSustento() {
        return idDocumentoSustento;
    }

    /**
     * Verifica si existe al menos un documento de sustento.
     */
    public boolean tieneDocumentos() {
        return (idActaSustento != null && !idActaSustento.isEmpty()) ||
               (idDocumentoSustento != null && !idDocumentoSustento.isEmpty());
    }

    /**
     * Verifica si tiene acta de sustento.
     */
    public boolean tieneActa() {
        return idActaSustento != null && !idActaSustento.isEmpty();
    }

    /**
     * Verifica si tiene documento de sustento.
     */
    public boolean tieneDocumento() {
        return idDocumentoSustento != null && !idDocumentoSustento.isEmpty();
    }
}
