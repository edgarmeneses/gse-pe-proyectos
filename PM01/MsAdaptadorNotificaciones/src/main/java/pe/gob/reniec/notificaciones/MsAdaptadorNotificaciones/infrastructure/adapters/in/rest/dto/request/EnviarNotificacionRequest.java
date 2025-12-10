package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.request;

import java.util.List;
import java.util.Map;

public class EnviarNotificacionRequest {
    private String plantillaId;
    private List<DestinatarioRequest> destinatarios;
    private List<String> canalesPrioritarios;
    private Map<String, String> parametros;
    private String asunto;
    private List<AdjuntoRequest> adjuntos;
    private String webhookUrl;
    private Map<String, String> webhookHeaders;
    private MetadataRequest metadata;

    public EnviarNotificacionRequest() {}

    public String getPlantillaId() {
        return plantillaId;
    }

    public void setPlantillaId(String plantillaId) {
        this.plantillaId = plantillaId;
    }

    public List<DestinatarioRequest> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<DestinatarioRequest> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public List<String> getCanalesPrioritarios() {
        return canalesPrioritarios;
    }

    public void setCanalesPrioritarios(List<String> canalesPrioritarios) {
        this.canalesPrioritarios = canalesPrioritarios;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public List<AdjuntoRequest> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<AdjuntoRequest> adjuntos) {
        this.adjuntos = adjuntos;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }

    public void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public Map<String, String> getWebhookHeaders() {
        return webhookHeaders;
    }

    public void setWebhookHeaders(Map<String, String> webhookHeaders) {
        this.webhookHeaders = webhookHeaders;
    }

    public MetadataRequest getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataRequest metadata) {
        this.metadata = metadata;
    }
}
