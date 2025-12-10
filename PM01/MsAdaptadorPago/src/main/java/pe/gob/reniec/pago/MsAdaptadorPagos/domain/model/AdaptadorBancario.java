package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

import java.time.LocalDateTime;

public class AdaptadorBancario {
    private String nombre;
    private String entidadBancaria;
    private String estado; // ACTIVO, INACTIVO
    private Boolean disponible;
    private EstadoDisponibilidad disponibilidad;
    private MetricasDesempeno metricas;
    private LocalDateTime ultimaVerificacion;

    public AdaptadorBancario() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEntidadBancaria() { return entidadBancaria; }
    public void setEntidadBancaria(String entidadBancaria) { this.entidadBancaria = entidadBancaria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }

    public EstadoDisponibilidad getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(EstadoDisponibilidad disponibilidad) { this.disponibilidad = disponibilidad; }

    public MetricasDesempeno getMetricas() { return metricas; }
    public void setMetricas(MetricasDesempeno metricas) { this.metricas = metricas; }

    public LocalDateTime getUltimaVerificacion() { return ultimaVerificacion; }
    public void setUltimaVerificacion(LocalDateTime ultimaVerificacion) { this.ultimaVerificacion = ultimaVerificacion; }
}
