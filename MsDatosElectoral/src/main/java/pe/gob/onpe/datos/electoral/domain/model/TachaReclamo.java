package pe.gob.onpe.datos.electoral.domain.model;

import java.time.LocalDateTime;

public class TachaReclamo {
    private Long id;
    private String tipo;
    private String numeroExpediente;
    private LocalDateTime fechaRegistro;
    private String estado;
    private String descripcion;
    private String solicitante;

    public TachaReclamo() {
    }

    public TachaReclamo(Long id, String tipo, String numeroExpediente, LocalDateTime fechaRegistro,
                        String estado, String descripcion, String solicitante) {
        this.id = id;
        this.tipo = tipo;
        this.numeroExpediente = numeroExpediente;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.descripcion = descripcion;
        this.solicitante = solicitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
}
