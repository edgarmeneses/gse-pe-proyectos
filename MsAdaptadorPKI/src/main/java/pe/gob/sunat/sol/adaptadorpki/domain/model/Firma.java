package pe.gob.sunat.sol.adaptadorpki.domain.model;

import java.time.LocalDateTime;

public class Firma {
    private String documento;
    private String certificado;
    private String password;
    private String tipoFirma;
    private String documentoFirmado;
    private LocalDateTime fechaFirma;
    private String codigoRespuesta;
    private String mensaje;

    public Firma() {
    }

    public Firma(String documento, String certificado, String password, String tipoFirma) {
        this.documento = documento;
        this.certificado = certificado;
        this.password = password;
        this.tipoFirma = tipoFirma;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoFirma() {
        return tipoFirma;
    }

    public void setTipoFirma(String tipoFirma) {
        this.tipoFirma = tipoFirma;
    }

    public String getDocumentoFirmado() {
        return documentoFirmado;
    }

    public void setDocumentoFirmado(String documentoFirmado) {
        this.documentoFirmado = documentoFirmado;
    }

    public LocalDateTime getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(LocalDateTime fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
