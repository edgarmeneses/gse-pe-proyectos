package pe.reniec.firma.domain.model;

public class Timestamp {
    private String fechaHoraFirma;
    private String autoridadTimestamp;
    private String algoritmoTimestamp;

    public Timestamp() {}

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
