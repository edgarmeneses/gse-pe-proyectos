package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response;

import java.time.LocalDateTime;

/**
 * Representa la respuesta técnica recibida del sistema PKI externo.
 * Esta clase es un DTO técnico que encapsula información de infraestructura,
 * NO es un concepto del dominio de negocio.
 */
public class RespuestaPKI {
    private String codigoRespuesta;
    private String mensajeRespuesta;
    private String idTransaccionPKI;
    private LocalDateTime timestampPKI;

    public RespuestaPKI() {
    }

    public RespuestaPKI(String codigoRespuesta, String mensajeRespuesta, String idTransaccionPKI,
                       LocalDateTime timestampPKI) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
        this.idTransaccionPKI = idTransaccionPKI;
        this.timestampPKI = timestampPKI;
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

    public LocalDateTime getTimestampPKI() {
        return timestampPKI;
    }

    public void setTimestampPKI(LocalDateTime timestampPKI) {
        this.timestampPKI = timestampPKI;
    }
}
