package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

public class MetricasDesempeno {
    private Integer requestsUltimaHora;
    private Integer exitosUltimaHora;
    private Integer fallosUltimaHora;
    private Double tasaExito;
    private Integer tiempoPromedioMs;

    public MetricasDesempeno() {}

    public Integer getRequestsUltimaHora() { return requestsUltimaHora; }
    public void setRequestsUltimaHora(Integer requestsUltimaHora) { this.requestsUltimaHora = requestsUltimaHora; }

    public Integer getExitosUltimaHora() { return exitosUltimaHora; }
    public void setExitosUltimaHora(Integer exitosUltimaHora) { this.exitosUltimaHora = exitosUltimaHora; }

    public Integer getFallosUltimaHora() { return fallosUltimaHora; }
    public void setFallosUltimaHora(Integer fallosUltimaHora) { this.fallosUltimaHora = fallosUltimaHora; }

    public Double getTasaExito() { return tasaExito; }
    public void setTasaExito(Double tasaExito) { this.tasaExito = tasaExito; }

    public Integer getTiempoPromedioMs() { return tiempoPromedioMs; }
    public void setTiempoPromedioMs(Integer tiempoPromedioMs) { this.tiempoPromedioMs = tiempoPromedioMs; }
}
