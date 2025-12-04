package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class PaqueteElectoralEntity {
    private Long id;
    private String numeroPaquete;
    private String estado;
    private LocalDateTime fechaRecepcion;
    private String ubicacion;
    private String observaciones;

    public PaqueteElectoralEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPaquete() {
        return numeroPaquete;
    }

    public void setNumeroPaquete(String numeroPaquete) {
        this.numeroPaquete = numeroPaquete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
