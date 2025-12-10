package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class DetalleRoutingDto {
    private String estrategiaUsada;
    private Integer tiempoRoutingMs;
    private Integer tiempoValidacionMs;
    private Integer tiempoTotalMs;
    private Integer intentosRealizados;
    private Boolean fallbackAplicado;
    private String circuitBreakerEstado;

    public DetalleRoutingDto() {}

    public String getEstrategiaUsada() { return estrategiaUsada; }
    public void setEstrategiaUsada(String estrategiaUsada) { this.estrategiaUsada = estrategiaUsada; }

    public Integer getTiempoRoutingMs() { return tiempoRoutingMs; }
    public void setTiempoRoutingMs(Integer tiempoRoutingMs) { this.tiempoRoutingMs = tiempoRoutingMs; }

    public Integer getTiempoValidacionMs() { return tiempoValidacionMs; }
    public void setTiempoValidacionMs(Integer tiempoValidacionMs) { this.tiempoValidacionMs = tiempoValidacionMs; }

    public Integer getTiempoTotalMs() { return tiempoTotalMs; }
    public void setTiempoTotalMs(Integer tiempoTotalMs) { this.tiempoTotalMs = tiempoTotalMs; }

    public Integer getIntentosRealizados() { return intentosRealizados; }
    public void setIntentosRealizados(Integer intentosRealizados) { this.intentosRealizados = intentosRealizados; }

    public Boolean getFallbackAplicado() { return fallbackAplicado; }
    public void setFallbackAplicado(Boolean fallbackAplicado) { this.fallbackAplicado = fallbackAplicado; }

    public String getCircuitBreakerEstado() { return circuitBreakerEstado; }
    public void setCircuitBreakerEstado(String circuitBreakerEstado) { this.circuitBreakerEstado = circuitBreakerEstado; }
}
