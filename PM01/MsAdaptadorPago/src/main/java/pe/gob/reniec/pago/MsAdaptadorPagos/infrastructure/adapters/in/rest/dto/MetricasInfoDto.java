package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class MetricasInfoDto {
    private Integer requestsUltima1h;
    private Integer exitosUltima1h;
    private Integer fallosUltima1h;
    private Double tasaExito;
    private Integer tiempoPromedioMs;

    public MetricasInfoDto() {}

    public Integer getRequestsUltima1h() { return requestsUltima1h; }
    public void setRequestsUltima1h(Integer requestsUltima1h) { this.requestsUltima1h = requestsUltima1h; }

    public Integer getExitosUltima1h() { return exitosUltima1h; }
    public void setExitosUltima1h(Integer exitosUltima1h) { this.exitosUltima1h = exitosUltima1h; }

    public Integer getFallosUltima1h() { return fallosUltima1h; }
    public void setFallosUltima1h(Integer fallosUltima1h) { this.fallosUltima1h = fallosUltima1h; }

    public Double getTasaExito() { return tasaExito; }
    public void setTasaExito(Double tasaExito) { this.tasaExito = tasaExito; }

    public Integer getTiempoPromedioMs() { return tiempoPromedioMs; }
    public void setTiempoPromedioMs(Integer tiempoPromedioMs) { this.tiempoPromedioMs = tiempoPromedioMs; }
}
