package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class RespuestaPKIDto {
    private String codigoRespuesta;
    private String mensajeRespuesta;
    private String idTransaccionPKI;
    private String timestampPKI;

    public RespuestaPKIDto() {
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public String getIdTransaccionPKI() {
        return idTransaccionPKI;
    }

    public void setIdTransaccionPKI(String idTransaccionPKI) {
        this.idTransaccionPKI = idTransaccionPKI;
    }

    public String getTimestampPKI() {
        return timestampPKI;
    }

    public void setTimestampPKI(String timestampPKI) {
        this.timestampPKI = timestampPKI;
    }
}
