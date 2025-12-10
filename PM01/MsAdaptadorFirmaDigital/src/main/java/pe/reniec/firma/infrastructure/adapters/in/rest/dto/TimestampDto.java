package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class TimestampDto {
    private String fechaHoraFirma;
    private String autoridadTimestamp;
    private String algoritmoTimestamp;

    public TimestampDto() {}

    public String getFechaHoraFirma() {
        return fechaHoraFirma;
    }

    public void setFechaHoraFirma(String fechaHoraFirma) {
        this.fechaHoraFirma = fechaHoraFirma;
    }

    public String getAutoridadTimestamp() {
        return autoridadTimestamp;
    }

    public void setAutoridadTimestamp(String autoridadTimestamp) {
        this.autoridadTimestamp = autoridadTimestamp;
    }

    public String getAlgoritmoTimestamp() {
        return algoritmoTimestamp;
    }

    public void setAlgoritmoTimestamp(String algoritmoTimestamp) {
        this.algoritmoTimestamp = algoritmoTimestamp;
    }
}
