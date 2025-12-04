package pe.gob.onpe.datos.electoral.domain.model;

import java.time.LocalDateTime;

public class Impugnacion {
    private Long id;
    private String numeroImpugnacion;
    private LocalDateTime fechaRegistro;
    private String estado;
    private String descripcion;
    private String tipo;

    public Impugnacion() {
    }

    public Impugnacion(Long id, String numeroImpugnacion, LocalDateTime fechaRegistro, 
                       String estado, String descripcion, String tipo) {
        this.id = id;
        this.numeroImpugnacion = numeroImpugnacion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroImpugnacion() {
        return numeroImpugnacion;
    }

    public void setNumeroImpugnacion(String numeroImpugnacion) {
        this.numeroImpugnacion = numeroImpugnacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
