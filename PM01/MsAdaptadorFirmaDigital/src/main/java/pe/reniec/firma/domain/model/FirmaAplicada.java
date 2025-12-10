package pe.reniec.firma.domain.model;

import java.time.LocalDateTime;

public class FirmaAplicada {
    private String certificadoId;
    private LocalDateTime timestampFirma;

    public FirmaAplicada() {}

    public String getCertificadoId() {
        return certificadoId;
    }

    public void setCertificadoId(String certificadoId) {
        this.certificadoId = certificadoId;
    }

    public LocalDateTime getTimestampFirma() {
        return timestampFirma;
    }

    public void setTimestampFirma(LocalDateTime timestampFirma) {
        this.timestampFirma = timestampFirma;
    }
}
