package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class AlertaEntity {
    private String id;
    private String ciudadanoId;
    private String situacion;
    private String motivo;
    private LocalDateTime fechaDeteccion;
    private String circunscripcionId;
    private String medioVerificacion;
    private String documentoSoporteId;
    private String equipoTrabajoId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String estado;

    public AlertaEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(String ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFechaDeteccion() {
        return fechaDeteccion;
    }

    public void setFechaDeteccion(LocalDateTime fechaDeteccion) {
        this.fechaDeteccion = fechaDeteccion;
    }

    public String getCircunscripcionId() {
        return circunscripcionId;
    }

    public void setCircunscripcionId(String circunscripcionId) {
        this.circunscripcionId = circunscripcionId;
    }

    public String getMedioVerificacion() {
        return medioVerificacion;
    }

    public void setMedioVerificacion(String medioVerificacion) {
        this.medioVerificacion = medioVerificacion;
    }

    public String getDocumentoSoporteId() {
        return documentoSoporteId;
    }

    public void setDocumentoSoporteId(String documentoSoporteId) {
        this.documentoSoporteId = documentoSoporteId;
    }

    public String getEquipoTrabajoId() {
        return equipoTrabajoId;
    }

    public void setEquipoTrabajoId(String equipoTrabajoId) {
        this.equipoTrabajoId = equipoTrabajoId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
