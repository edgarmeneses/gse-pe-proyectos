package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.request;

public class MetadataRequest {
    private String tramiteId;
    private String oficinaOrigen;
    private String tipoTramiteId;

    public MetadataRequest() {}

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public String getTipoTramiteId() {
        return tipoTramiteId;
    }

    public void setTipoTramiteId(String tipoTramiteId) {
        this.tipoTramiteId = tipoTramiteId;
    }
}
