package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

public class ReglasEnrutamiento {
    private Boolean permitirFallback;
    private Integer timeout;
    private Integer maxReintentos;
    private String estrategiaIdentificacion;

    public ReglasEnrutamiento() {}

    public Boolean getPermitirFallback() { return permitirFallback; }
    public void setPermitirFallback(Boolean permitirFallback) { this.permitirFallback = permitirFallback; }

    public Integer getTimeout() { return timeout; }
    public void setTimeout(Integer timeout) { this.timeout = timeout; }

    public Integer getMaxReintentos() { return maxReintentos; }
    public void setMaxReintentos(Integer maxReintentos) { this.maxReintentos = maxReintentos; }

    public String getEstrategiaIdentificacion() { return estrategiaIdentificacion; }
    public void setEstrategiaIdentificacion(String estrategiaIdentificacion) { this.estrategiaIdentificacion = estrategiaIdentificacion; }
}
