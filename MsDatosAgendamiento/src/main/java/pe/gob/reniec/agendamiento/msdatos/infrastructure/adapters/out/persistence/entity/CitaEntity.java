package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class CitaEntity {
    private String citaId;
    private String codigoCita;
    private String estadoCodigo;
    private String estadoDescripcion;
    private Boolean estadoPermiteModificacion;
    private Boolean estadoPermiteCancelacion;
    private String sedeCodigoSede;
    private String sedeNombreSede;
    private String sedeDireccion;
    private String sedeTelefono;
    private String solicitudIdSolicitud;
    private String solicitudNumeroTramite;
    private String solicitanteDni;
    private String solicitanteNombres;
    private String solicitanteApellidoPaterno;
    private String solicitanteApellidoMaterno;
    private String solicitanteNombreCompleto;
    private String solicitanteEmail;
    private String solicitanteTelefono;
    private LocalDateTime programacionFechaCita;
    private String programacionHoraCita;
    private LocalDateTime programacionFechaHoraCompleta;
    private String programacionIdDisponibilidad;
    private String tecnicoIdTecnico;
    private String tecnicoNombreCompleto;
    private String tokenReagendamiento;
    private LocalDateTime fechaLimiteReagendamiento;
    private Integer cantidadReagendamientos;
    private Integer maximoReagendamientos;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;

    public CitaEntity() {
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

    public String getEstadoCodigo() {
        return estadoCodigo;
    }

    public void setEstadoCodigo(String estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }

    public Boolean getEstadoPermiteModificacion() {
        return estadoPermiteModificacion;
    }

    public void setEstadoPermiteModificacion(Boolean estadoPermiteModificacion) {
        this.estadoPermiteModificacion = estadoPermiteModificacion;
    }

    public Boolean getEstadoPermiteCancelacion() {
        return estadoPermiteCancelacion;
    }

    public void setEstadoPermiteCancelacion(Boolean estadoPermiteCancelacion) {
        this.estadoPermiteCancelacion = estadoPermiteCancelacion;
    }

    public String getSedeCodigoSede() {
        return sedeCodigoSede;
    }

    public void setSedeCodigoSede(String sedeCodigoSede) {
        this.sedeCodigoSede = sedeCodigoSede;
    }

    public String getSedeNombreSede() {
        return sedeNombreSede;
    }

    public void setSedeNombreSede(String sedeNombreSede) {
        this.sedeNombreSede = sedeNombreSede;
    }

    public String getSedeDireccion() {
        return sedeDireccion;
    }

    public void setSedeDireccion(String sedeDireccion) {
        this.sedeDireccion = sedeDireccion;
    }

    public String getSedeTelefono() {
        return sedeTelefono;
    }

    public void setSedeTelefono(String sedeTelefono) {
        this.sedeTelefono = sedeTelefono;
    }

    public String getSolicitudIdSolicitud() {
        return solicitudIdSolicitud;
    }

    public void setSolicitudIdSolicitud(String solicitudIdSolicitud) {
        this.solicitudIdSolicitud = solicitudIdSolicitud;
    }

    public String getSolicitudNumeroTramite() {
        return solicitudNumeroTramite;
    }

    public void setSolicitudNumeroTramite(String solicitudNumeroTramite) {
        this.solicitudNumeroTramite = solicitudNumeroTramite;
    }

    public String getSolicitanteDni() {
        return solicitanteDni;
    }

    public void setSolicitanteDni(String solicitanteDni) {
        this.solicitanteDni = solicitanteDni;
    }

    public String getSolicitanteNombres() {
        return solicitanteNombres;
    }

    public void setSolicitanteNombres(String solicitanteNombres) {
        this.solicitanteNombres = solicitanteNombres;
    }

    public String getSolicitanteApellidoPaterno() {
        return solicitanteApellidoPaterno;
    }

    public void setSolicitanteApellidoPaterno(String solicitanteApellidoPaterno) {
        this.solicitanteApellidoPaterno = solicitanteApellidoPaterno;
    }

    public String getSolicitanteApellidoMaterno() {
        return solicitanteApellidoMaterno;
    }

    public void setSolicitanteApellidoMaterno(String solicitanteApellidoMaterno) {
        this.solicitanteApellidoMaterno = solicitanteApellidoMaterno;
    }

    public String getSolicitanteNombreCompleto() {
        return solicitanteNombreCompleto;
    }

    public void setSolicitanteNombreCompleto(String solicitanteNombreCompleto) {
        this.solicitanteNombreCompleto = solicitanteNombreCompleto;
    }

    public String getSolicitanteEmail() {
        return solicitanteEmail;
    }

    public void setSolicitanteEmail(String solicitanteEmail) {
        this.solicitanteEmail = solicitanteEmail;
    }

    public String getSolicitanteTelefono() {
        return solicitanteTelefono;
    }

    public void setSolicitanteTelefono(String solicitanteTelefono) {
        this.solicitanteTelefono = solicitanteTelefono;
    }

    public LocalDateTime getProgramacionFechaCita() {
        return programacionFechaCita;
    }

    public void setProgramacionFechaCita(LocalDateTime programacionFechaCita) {
        this.programacionFechaCita = programacionFechaCita;
    }

    public String getProgramacionHoraCita() {
        return programacionHoraCita;
    }

    public void setProgramacionHoraCita(String programacionHoraCita) {
        this.programacionHoraCita = programacionHoraCita;
    }

    public LocalDateTime getProgramacionFechaHoraCompleta() {
        return programacionFechaHoraCompleta;
    }

    public void setProgramacionFechaHoraCompleta(LocalDateTime programacionFechaHoraCompleta) {
        this.programacionFechaHoraCompleta = programacionFechaHoraCompleta;
    }

    public String getProgramacionIdDisponibilidad() {
        return programacionIdDisponibilidad;
    }

    public void setProgramacionIdDisponibilidad(String programacionIdDisponibilidad) {
        this.programacionIdDisponibilidad = programacionIdDisponibilidad;
    }

    public String getTecnicoIdTecnico() {
        return tecnicoIdTecnico;
    }

    public void setTecnicoIdTecnico(String tecnicoIdTecnico) {
        this.tecnicoIdTecnico = tecnicoIdTecnico;
    }

    public String getTecnicoNombreCompleto() {
        return tecnicoNombreCompleto;
    }

    public void setTecnicoNombreCompleto(String tecnicoNombreCompleto) {
        this.tecnicoNombreCompleto = tecnicoNombreCompleto;
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

    public Integer getCantidadReagendamientos() {
        return cantidadReagendamientos;
    }

    public void setCantidadReagendamientos(Integer cantidadReagendamientos) {
        this.cantidadReagendamientos = cantidadReagendamientos;
    }

    public Integer getMaximoReagendamientos() {
        return maximoReagendamientos;
    }

    public void setMaximoReagendamientos(Integer maximoReagendamientos) {
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
