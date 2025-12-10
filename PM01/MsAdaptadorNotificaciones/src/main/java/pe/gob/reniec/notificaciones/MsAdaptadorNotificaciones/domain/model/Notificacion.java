package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Notificacion {
    private UUID notificacionId;
    private String plantillaId;
    private List<Destinatario> destinatarios;
    private List<String> canalesPrioritarios;
    private Map<String, String> parametros;
    private String asunto;
    private List<Adjunto> adjuntos;
    private String webhookUrl;
    private Map<String, String> webhookHeaders;
    private Metadata metadata;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaEnvioEstimada;
    private String tiempoEstimadoEntrega;
    private String urlConsulta;
    private Map<String, String> links;
    private Integer destinatariosExitosos;
    private Integer destinatariosFallidos;
    private List<CanalUtilizado> canalesUtilizados;

    public Notificacion() {}

    public UUID getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(UUID notificacionId) {
        this.notificacionId = notificacionId;
    }

    public String getPlantillaId() {
        return plantillaId;
    }

    public void setPlantillaId(String plantillaId) {
        this.plantillaId = plantillaId;
    }

    public List<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Destinatario> destinatarios) {
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

    public List<Adjunto> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<Adjunto> adjuntos) {
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

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaEnvioEstimada() {
        return fechaEnvioEstimada;
    }

    public void setFechaEnvioEstimada(LocalDateTime fechaEnvioEstimada) {
        this.fechaEnvioEstimada = fechaEnvioEstimada;
    }

    public String getTiempoEstimadoEntrega() {
        return tiempoEstimadoEntrega;
    }

    public void setTiempoEstimadoEntrega(String tiempoEstimadoEntrega) {
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
    }

    public String getUrlConsulta() {
        return urlConsulta;
    }

    public void setUrlConsulta(String urlConsulta) {
        this.urlConsulta = urlConsulta;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

    public Integer getDestinatariosExitosos() {
        return destinatariosExitosos;
    }

    public void setDestinatariosExitosos(Integer destinatariosExitosos) {
        this.destinatariosExitosos = destinatariosExitosos;
    }

    public Integer getDestinatariosFallidos() {
        return destinatariosFallidos;
    }

    public void setDestinatariosFallidos(Integer destinatariosFallidos) {
        this.destinatariosFallidos = destinatariosFallidos;
    }

    public List<CanalUtilizado> getCanalesUtilizados() {
        return canalesUtilizados;
    }

    public void setCanalesUtilizados(List<CanalUtilizado> canalesUtilizados) {
        this.canalesUtilizados = canalesUtilizados;
    }
}
