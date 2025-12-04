package pe.gob.onpe.datos.electoral.domain.model;

import java.time.LocalDateTime;

public class PaqueteElectoral {
    private Long id;
    private String numeroPaquete;
    private String estado;
    private LocalDateTime fechaRecepcion;
    private String ubicacion;
    private String observaciones;

    public PaqueteElectoral() {
    }

    public PaqueteElectoral(Long id, String numeroPaquete, String estado, LocalDateTime fechaRecepcion,
                            String ubicacion, String observaciones) {
        this.id = id;
        this.numeroPaquete = numeroPaquete;
        this.estado = estado;
        this.fechaRecepcion = fechaRecepcion;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
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
