package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class SustentoDto {
    private String idActaSustento;
    private String idDocumentoSustento;

    public SustentoDto() {
    }

    public SustentoDto(String idActaSustento, String idDocumentoSustento) {
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
