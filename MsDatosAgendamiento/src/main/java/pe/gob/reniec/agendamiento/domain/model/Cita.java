package pe.gob.reniec.agendamiento.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cita {
    private String citaId;
    private String codigoCita;
    private String estado;
    private SedeServicio sedeServicio;
    private Solicitud solicitud;
    private Solicitante solicitante;
    private Programacion programacion;
    private TecnicoAsignado tecnicoAsignado;
    private String tokenReagendamiento;
    private LocalDateTime fechaLimiteReagendamiento;
    private Long cantidadReagendamientos;
    private Long maximoReagendamientos;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;

    public Cita() {
    }

    public String getCitaId() {
        return citaId;
    }

    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SedeServicio getSedeServicio() {
        return sedeServicio;
    }

    public void setSedeServicio(SedeServicio sedeServicio) {
        this.sedeServicio = sedeServicio;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public TecnicoAsignado getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(TecnicoAsignado tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public String getTokenReagendamiento() {
        return tokenReagendamiento;
    }

    public void setTokenReagendamiento(String tokenReagendamiento) {
        this.tokenReagendamiento = tokenReagendamiento;
    }

    public LocalDateTime getFechaLimiteReagendamiento() {
        return fechaLimiteReagendamiento;
    }

    public void setFechaLimiteReagendamiento(LocalDateTime fechaLimiteReagendamiento) {
        this.fechaLimiteReagendamiento = fechaLimiteReagendamiento;
    }

    public Long getCantidadReagendamientos() {
        return cantidadReagendamientos;
    }

    public void setCantidadReagendamientos(Long cantidadReagendamientos) {
        this.cantidadReagendamientos = cantidadReagendamientos;
    }

    public Long getMaximoReagendamientos() {
        return maximoReagendamientos;
    }

    public void setMaximoReagendamientos(Long maximoReagendamientos) {
        this.maximoReagendamientos = maximoReagendamientos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
}
