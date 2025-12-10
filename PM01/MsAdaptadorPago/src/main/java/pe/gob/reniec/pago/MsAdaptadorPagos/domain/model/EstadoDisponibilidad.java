package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

import java.time.LocalDateTime;

public class EstadoDisponibilidad {
    private String estado; // OPEN, CLOSED, HALF_OPEN
    private Integer fallosConsecutivos;
    private LocalDateTime ultimoFallo;
    private LocalDateTime proximaEvaluacion;

    public EstadoDisponibilidad() {}

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Integer getFallosConsecutivos() { return fallosConsecutivos; }
    public void setFallosConsecutivos(Integer fallosConsecutivos) { this.fallosConsecutivos = fallosConsecutivos; }

    public LocalDateTime getUltimoFallo() { return ultimoFallo; }
    public void setUltimoFallo(LocalDateTime ultimoFallo) { this.ultimoFallo = ultimoFallo; }

    public LocalDateTime getProximaEvaluacion() { return proximaEvaluacion; }
    public void setProximaEvaluacion(LocalDateTime proximaEvaluacion) { this.proximaEvaluacion = proximaEvaluacion; }
}
