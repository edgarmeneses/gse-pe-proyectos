package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class GenerarCertificadoDigitalResponseDto {
    private String resultado;
    private String mensaje;
    private List<CertificadoDigitalResponseDto> certificados;
    private RespuestaPKIDto pkiExterno;
    private MetadataRespuestaDto metadata;

    public GenerarCertificadoDigitalResponseDto() {
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<CertificadoDigitalResponseDto> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<CertificadoDigitalResponseDto> certificados) {
        this.certificados = certificados;
    }

    public RespuestaPKIDto getPkiExterno() {
        return pkiExterno;
    }

    public void setPkiExterno(RespuestaPKIDto pkiExterno) {
        this.pkiExterno = pkiExterno;
    }

    public MetadataRespuestaDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataRespuestaDto metadata) {
        this.metadata = metadata;
    }
}
