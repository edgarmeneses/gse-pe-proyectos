package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class FirmaAplicadaDto {
    private String certificadoId;
    private String timestampFirma;

    public FirmaAplicadaDto() {}

    public String getCertificadoId() {
        return certificadoId;
    }

    public void setCertificadoId(String certificadoId) {
        this.certificadoId = certificadoId;
    }

    public String getTimestampFirma() {
        return timestampFirma;
    }

    public void setTimestampFirma(String timestampFirma) {
        this.timestampFirma = timestampFirma;
    }
}
