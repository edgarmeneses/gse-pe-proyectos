package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class CircuitBreakerInfoDto {
    private String estado;
    private Integer fallosConsecutivos;
    private String ultimoFallo;
    private String proximaEvaluacion;

    public CircuitBreakerInfoDto() {}

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Integer getFallosConsecutivos() { return fallosConsecutivos; }
    public void setFallosConsecutivos(Integer fallosConsecutivos) { this.fallosConsecutivos = fallosConsecutivos; }

    public String getUltimoFallo() { return ultimoFallo; }
    public void setUltimoFallo(String ultimoFallo) { this.ultimoFallo = ultimoFallo; }

    public String getProximaEvaluacion() { return proximaEvaluacion; }
    public void setProximaEvaluacion(String proximaEvaluacion) { this.proximaEvaluacion = proximaEvaluacion; }
}
