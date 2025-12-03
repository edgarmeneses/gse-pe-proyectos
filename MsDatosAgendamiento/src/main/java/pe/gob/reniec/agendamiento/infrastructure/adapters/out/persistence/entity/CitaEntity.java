package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class CitaEntity {
    private String citaId;
    private String codigoCita;
    private String estado;
    private String codigoSede;
    private String nombreSede;
    private String direccionSede;
    private String telefonoSede;
    private Long capacidadDiariaMaxima;
    private Long tiempoAtencionMinutos;
    private String idSolicitud;
    private String numeroTramite;
    private String dniSolicitante;
    private String nombresSolicitante;
    private String apellidoPaternoSolicitante;
    private String apellidoMaternoSolicitante;
    private String nombreCompletoSolicitante;
    private String emailSolicitante;
    private String telefonoSolicitante;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private LocalDateTime fechaHoraCompleta;
    private String idDisponibilidad;
    private String idTecnico;
    private String nombreCompletoTecnico;
    private String tokenReagendamiento;
    private LocalDateTime fechaLimiteReagendamiento;
    private Long cantidadReagendamientos;
    private Long maximoReagendamientos;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;

    public CitaEntity() {
    }

    public CitaEntity(String citaId, String codigoCita, String estado, String codigoSede, String nombreSede, 
                      String direccionSede, String telefonoSede, Long capacidadDiariaMaxima, Long tiempoAtencionMinutos,
                      String idSolicitud, String numeroTramite, String dniSolicitante, String nombresSolicitante,
                      String apellidoPaternoSolicitante, String apellidoMaternoSolicitante, String nombreCompletoSolicitante,
                      String emailSolicitante, String telefonoSolicitante, LocalDate fechaCita, LocalTime horaCita,
                      LocalDateTime fechaHoraCompleta, String idDisponibilidad, String idTecnico, String nombreCompletoTecnico,
                      String tokenReagendamiento, LocalDateTime fechaLimiteReagendamiento, Long cantidadReagendamientos,
                      Long maximoReagendamientos, String observaciones, LocalDateTime fechaRegistro, String usuarioRegistro,
                      LocalDateTime fechaActualizacion, String usuarioActualizacion) {
        this.citaId = citaId;
        this.codigoCita = codigoCita;
        this.estado = estado;
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
        this.direccionSede = direccionSede;
        this.telefonoSede = telefonoSede;
        this.capacidadDiariaMaxima = capacidadDiariaMaxima;
        this.tiempoAtencionMinutos = tiempoAtencionMinutos;
        this.idSolicitud = idSolicitud;
        this.numeroTramite = numeroTramite;
        this.dniSolicitante = dniSolicitante;
        this.nombresSolicitante = nombresSolicitante;
        this.apellidoPaternoSolicitante = apellidoPaternoSolicitante;
        this.apellidoMaternoSolicitante = apellidoMaternoSolicitante;
        this.nombreCompletoSolicitante = nombreCompletoSolicitante;
        this.emailSolicitante = emailSolicitante;
        this.telefonoSolicitante = telefonoSolicitante;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.fechaHoraCompleta = fechaHoraCompleta;
        this.idDisponibilidad = idDisponibilidad;
        this.idTecnico = idTecnico;
        this.nombreCompletoTecnico = nombreCompletoTecnico;
        this.tokenReagendamiento = tokenReagendamiento;
        this.fechaLimiteReagendamiento = fechaLimiteReagendamiento;
        this.cantidadReagendamientos = cantidadReagendamientos;
        this.maximoReagendamientos = maximoReagendamientos;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.usuarioActualizacion = usuarioActualizacion;
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

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public String getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(String telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    public Long getCapacidadDiariaMaxima() {
        return capacidadDiariaMaxima;
    }

    public void setCapacidadDiariaMaxima(Long capacidadDiariaMaxima) {
        this.capacidadDiariaMaxima = capacidadDiariaMaxima;
    }

    public Long getTiempoAtencionMinutos() {
        return tiempoAtencionMinutos;
    }

    public void setTiempoAtencionMinutos(Long tiempoAtencionMinutos) {
        this.tiempoAtencionMinutos = tiempoAtencionMinutos;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public String getDniSolicitante() {
        return dniSolicitante;
    }

    public void setDniSolicitante(String dniSolicitante) {
        this.dniSolicitante = dniSolicitante;
    }

    public String getNombresSolicitante() {
        return nombresSolicitante;
    }

    public void setNombresSolicitante(String nombresSolicitante) {
        this.nombresSolicitante = nombresSolicitante;
    }

    public String getApellidoPaternoSolicitante() {
        return apellidoPaternoSolicitante;
    }

    public void setApellidoPaternoSolicitante(String apellidoPaternoSolicitante) {
        this.apellidoPaternoSolicitante = apellidoPaternoSolicitante;
    }

    public String getApellidoMaternoSolicitante() {
        return apellidoMaternoSolicitante;
    }

    public void setApellidoMaternoSolicitante(String apellidoMaternoSolicitante) {
        this.apellidoMaternoSolicitante = apellidoMaternoSolicitante;
    }

    public String getNombreCompletoSolicitante() {
        return nombreCompletoSolicitante;
    }

    public void setNombreCompletoSolicitante(String nombreCompletoSolicitante) {
        this.nombreCompletoSolicitante = nombreCompletoSolicitante;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

    public String getTelefonoSolicitante() {
        return telefonoSolicitante;
    }

    public void setTelefonoSolicitante(String telefonoSolicitante) {
        this.telefonoSolicitante = telefonoSolicitante;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public LocalDateTime getFechaHoraCompleta() {
        return fechaHoraCompleta;
    }

    public void setFechaHoraCompleta(LocalDateTime fechaHoraCompleta) {
        this.fechaHoraCompleta = fechaHoraCompleta;
    }

    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombreCompletoTecnico() {
        return nombreCompletoTecnico;
    }

    public void setNombreCompletoTecnico(String nombreCompletoTecnico) {
        this.nombreCompletoTecnico = nombreCompletoTecnico;
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
