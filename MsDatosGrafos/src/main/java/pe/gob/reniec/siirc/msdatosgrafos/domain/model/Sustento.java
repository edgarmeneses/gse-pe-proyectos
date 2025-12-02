package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Value Object que representa los documentos de sustento de una relación
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
}
