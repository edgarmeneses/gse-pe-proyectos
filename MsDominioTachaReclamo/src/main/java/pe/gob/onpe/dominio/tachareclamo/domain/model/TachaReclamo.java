package pe.gob.onpe.dominio.tachareclamo.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class TachaReclamo {
    private Long id;
    private String tipo;
    private String numeroExpediente;
    private LocalDateTime fechaRegistro;
    private String estado;
    private String descripcion;
    private String solicitante;
    private String sustento;
    private List<String> documentos;
    private String areaActual;
    private String responsableActual;

    public TachaReclamo() {
    }

    public TachaReclamo(Long id, String tipo, String numeroExpediente, LocalDateTime fechaRegistro,
                        String estado, String descripcion, String solicitante, String sustento,
                        List<String> documentos, String areaActual, String responsableActual) {
        this.id = id;
        this.tipo = tipo;
        this.numeroExpediente = numeroExpediente;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.descripcion = descripcion;
        this.solicitante = solicitante;
        this.sustento = sustento;
        this.documentos = documentos;
        this.areaActual = areaActual;
        this.responsableActual = responsableActual;
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

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public List<String> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<String> documentos) {
        this.documentos = documentos;
    }

    public String getAreaActual() {
        return areaActual;
    }

    public void setAreaActual(String areaActual) {
        this.areaActual = areaActual;
    }

    public String getResponsableActual() {
        return responsableActual;
    }

    public void setResponsableActual(String responsableActual) {
        this.responsableActual = responsableActual;
    }
}
