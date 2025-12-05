package pe.gob.reniec.circunscripciones.domain.model;

public class ActaVirtual {

    private String actaId;
    private String equipoId;
    private String urlAccesoMovil;
    private String qrCode;

    public ActaVirtual() {
    }

    public ActaVirtual(String actaId, String equipoId, String urlAccesoMovil, String qrCode) {
        this.actaId = actaId;
        this.equipoId = equipoId;
        this.urlAccesoMovil = urlAccesoMovil;
        this.qrCode = qrCode;
    }

    public String getActaId() {
        return actaId;
    }

    public void setActaId(String actaId) {
        this.actaId = actaId;
    }

    public String getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(String equipoId) {
        this.equipoId = equipoId;
    }

    public String getUrlAccesoMovil() {
        return urlAccesoMovil;
    }

    public void setUrlAccesoMovil(String urlAccesoMovil) {
        this.urlAccesoMovil = urlAccesoMovil;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
