package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class DetalleFirmaDto {
    private Integer numeroFirma;
    private FirmanteDto firmante;
    private CertificadoDto certificado;
    private ValidacionEstadoDto validaciones;
    private TimestampDto timestamp;
    private DetallesValidacionDto detallesValidacion;

    public DetalleFirmaDto() {}

    public Integer getNumeroFirma() {
        return numeroFirma;
    }

    public void setNumeroFirma(Integer numeroFirma) {
        this.numeroFirma = numeroFirma;
    }

    public FirmanteDto getFirmante() {
        return firmante;
    }

    public void setFirmante(FirmanteDto firmante) {
        this.firmante = firmante;
    }

    public CertificadoDto getCertificado() {
        return certificado;
    }

    public void setCertificado(CertificadoDto certificado) {
        this.certificado = certificado;
    }

    public ValidacionEstadoDto getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionEstadoDto validaciones) {
        this.validaciones = validaciones;
    }

    public TimestampDto getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(TimestampDto timestamp) {
        this.timestamp = timestamp;
    }

    public DetallesValidacionDto getDetallesValidacion() {
        return detallesValidacion;
    }

    public void setDetallesValidacion(DetallesValidacionDto detallesValidacion) {
        this.detallesValidacion = detallesValidacion;
    }
}
