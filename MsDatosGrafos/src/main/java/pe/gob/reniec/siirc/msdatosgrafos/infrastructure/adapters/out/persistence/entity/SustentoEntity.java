package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

/**
 * Entity para persistencia de Sustento
 * POJO sin anotaciones de framework
 */
public class SustentoEntity {
    private String idActaSustento;
    private String idDocumentoSustento;

    public SustentoEntity() {
    }

    public SustentoEntity(String idActaSustento, String idDocumentoSustento) {
        this.idActaSustento = idActaSustento;
        this.idDocumentoSustento = idDocumentoSustento;
    }

    public String getIdActaSustento() {
        return idActaSustento;
    }

    public void setIdActaSustento(String idActaSustento) {
        this.idActaSustento = idActaSustento;
    }

    public String getIdDocumentoSustento() {
        return idDocumentoSustento;
    }

    public void setIdDocumentoSustento(String idDocumentoSustento) {
        this.idDocumentoSustento = idDocumentoSustento;
    }
}
