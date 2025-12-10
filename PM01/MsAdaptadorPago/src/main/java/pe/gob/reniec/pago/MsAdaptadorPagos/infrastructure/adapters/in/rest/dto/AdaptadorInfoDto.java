package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class AdaptadorInfoDto {
    private String nombre;
    private String entidadBancaria;
    private String estado;
    private Boolean disponible;
    private CircuitBreakerInfoDto circuitBreaker;
    private MetricasInfoDto metricas;
    private String ultimaVerificacion;

    public AdaptadorInfoDto() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEntidadBancaria() { return entidadBancaria; }
    public void setEntidadBancaria(String entidadBancaria) { this.entidadBancaria = entidadBancaria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }

    public CircuitBreakerInfoDto getCircuitBreaker() { return circuitBreaker; }
    public void setCircuitBreaker(CircuitBreakerInfoDto circuitBreaker) { this.circuitBreaker = circuitBreaker; }

    public MetricasInfoDto getMetricas() { return metricas; }
    public void setMetricas(MetricasInfoDto metricas) { this.metricas = metricas; }

    public String getUltimaVerificacion() { return ultimaVerificacion; }
    public void setUltimaVerificacion(String ultimaVerificacion) { this.ultimaVerificacion = ultimaVerificacion; }
}
