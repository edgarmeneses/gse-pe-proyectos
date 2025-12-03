package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CitaEntity {
    
    private String citaId;
    private String codigoCita;
    private String estadoCodigo;
    private String estadoDescripcion;
    private Boolean permiteModificacion;
    private Boolean permiteCancelacion;
    private String codigoSede;
    private String nombreSede;
    private String direccionSede;
    private String telefonoSede;
    private String idSolicitud;
    private String numeroTramite;
    private String dniSolicitante;
    private String nombresSolicitante;
    private String apellidoPaternoSolicitante;
    private String apellidoMaternoSolicitante;
    private String emailSolicitante;
    private String telefonoSolicitante;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String idDisponibilidad;
    private String idTecnico;
    private String nombreCompletoTecnico;
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
    
    // Getters y Setters
    
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
    
    public Boolean getPermiteModificacion() {
        return permiteModificacion;
    }
    
    public void setPermiteModificacion(Boolean permiteModificacion) {
        this.permiteModificacion = permiteModificacion;
    }
    
    public Boolean getPermiteCancelacion() {
        return permiteCancelacion;
    }
    
    public void setPermiteCancelacion(Boolean permiteCancelacion) {
        this.permiteCancelacion = permiteCancelacion;
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
