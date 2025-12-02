package pe.gob.reniec.dominio.parentesco.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class AnalisisParentesco {
    private String idAnalisis;
    private String idSolicitud;
    private String idCiudadanoConsultado;
    private String tipoVinculo;
    private Integer nivelComplejidad;
    private String estado;
    private CiudadanoAnalizado ciudadanoAnalizado;
    private PoblacionVinculosPosibles poblacionVinculosPosibles;
    private ResumenAnalisis resumenAnalisis;
    private List<Inconsistencia> inconsistencias;
    private List<ActaPendienteDigitalizacion> actasPendientesDigitalizacion;
    private LocalDateTime fechaAnalisis;
    private Integer tiempoProcesamientoMs;
    private String usuarioTecnico;

    public AnalisisParentesco() {
    }

    public AnalisisParentesco(String idAnalisis, String idSolicitud, String idCiudadanoConsultado,
                             String tipoVinculo, Integer nivelComplejidad, String estado,
                             CiudadanoAnalizado ciudadanoAnalizado, PoblacionVinculosPosibles poblacionVinculosPosibles,
                             ResumenAnalisis resumenAnalisis, List<Inconsistencia> inconsistencias,
                             List<ActaPendienteDigitalizacion> actasPendientesDigitalizacion,
                             LocalDateTime fechaAnalisis, Integer tiempoProcesamientoMs, String usuarioTecnico) {
        this.idAnalisis = idAnalisis;
        this.idSolicitud = idSolicitud;
        this.idCiudadanoConsultado = idCiudadanoConsultado;
        this.tipoVinculo = tipoVinculo;
        this.nivelComplejidad = nivelComplejidad;
        this.estado = estado;
        this.ciudadanoAnalizado = ciudadanoAnalizado;
        this.poblacionVinculosPosibles = poblacionVinculosPosibles;
        this.resumenAnalisis = resumenAnalisis;
        this.inconsistencias = inconsistencias;
        this.actasPendientesDigitalizacion = actasPendientesDigitalizacion;
        this.fechaAnalisis = fechaAnalisis;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        this.usuarioTecnico = usuarioTecnico;
    }

    public String getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(String idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getIdCiudadanoConsultado() {
        return idCiudadanoConsultado;
    }

    public void setIdCiudadanoConsultado(String idCiudadanoConsultado) {
        this.idCiudadanoConsultado = idCiudadanoConsultado;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public Integer getNivelComplejidad() {
        return nivelComplejidad;
    }

    public void setNivelComplejidad(Integer nivelComplejidad) {
        this.nivelComplejidad = nivelComplejidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CiudadanoAnalizado getCiudadanoAnalizado() {
        return ciudadanoAnalizado;
    }

    public void setCiudadanoAnalizado(CiudadanoAnalizado ciudadanoAnalizado) {
        this.ciudadanoAnalizado = ciudadanoAnalizado;
    }

    public PoblacionVinculosPosibles getPoblacionVinculosPosibles() {
        return poblacionVinculosPosibles;
    }

    public void setPoblacionVinculosPosibles(PoblacionVinculosPosibles poblacionVinculosPosibles) {
        this.poblacionVinculosPosibles = poblacionVinculosPosibles;
    }

    public ResumenAnalisis getResumenAnalisis() {
        return resumenAnalisis;
    }

    public void setResumenAnalisis(ResumenAnalisis resumenAnalisis) {
        this.resumenAnalisis = resumenAnalisis;
    }

    public List<Inconsistencia> getInconsistencias() {
        return inconsistencias;
    }

    public void setInconsistencias(List<Inconsistencia> inconsistencias) {
        this.inconsistencias = inconsistencias;
    }

    public List<ActaPendienteDigitalizacion> getActasPendientesDigitalizacion() {
        return actasPendientesDigitalizacion;
    }

    public void setActasPendientesDigitalizacion(List<ActaPendienteDigitalizacion> actasPendientesDigitalizacion) {
        this.actasPendientesDigitalizacion = actasPendientesDigitalizacion;
    }

    public LocalDateTime getFechaAnalisis() {
        return fechaAnalisis;
    }

    public void setFechaAnalisis(LocalDateTime fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
    }

    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }

    public String getUsuarioTecnico() {
        return usuarioTecnico;
    }

    public void setUsuarioTecnico(String usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }
}
