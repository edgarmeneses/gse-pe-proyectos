package pe.com.organizacion.cotejomasivo.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aggregate Root: CotejoMasivo
 * Representa una ejecución de cotejo masivo de datos
 */
public class CotejoMasivo {
    
    private String idEjecucion;
    private LocalDateTime fechaSolicitud;
    private String estado;
    private List<CriterioCotejo> criteriosCotejo;
    private Long totalRegistros;
    private Long registrosProcesados;
    private Long registrosExitosos;
    private Long registrosConError;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String usuarioSolicitante;
    
    public CotejoMasivo() {
    }
    
    public CotejoMasivo(String idEjecucion, LocalDateTime fechaSolicitud, String estado,
                       List<CriterioCotejo> criteriosCotejo, Long totalRegistros,
                       Long registrosProcesados, Long registrosExitosos, Long registrosConError,
                       LocalDateTime fechaInicio, LocalDateTime fechaFin, String usuarioSolicitante) {
        this.idEjecucion = idEjecucion;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.criteriosCotejo = criteriosCotejo;
        this.totalRegistros = totalRegistros;
        this.registrosProcesados = registrosProcesados;
        this.registrosExitosos = registrosExitosos;
        this.registrosConError = registrosConError;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioSolicitante = usuarioSolicitante;
    }
    
    public String getIdEjecucion() {
        return idEjecucion;
    }
    
    public void setIdEjecucion(String idEjecucion) {
        this.idEjecucion = idEjecucion;
    }
    
    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<CriterioCotejo> getCriteriosCotejo() {
        return criteriosCotejo;
    }
    
    public void setCriteriosCotejo(List<CriterioCotejo> criteriosCotejo) {
        this.criteriosCotejo = criteriosCotejo;
    }
    
    public Long getTotalRegistros() {
        return totalRegistros;
    }
    
    public void setTotalRegistros(Long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    
    public Long getRegistrosProcesados() {
        return registrosProcesados;
    }
    
    public void setRegistrosProcesados(Long registrosProcesados) {
        this.registrosProcesados = registrosProcesados;
    }
    
    public Long getRegistrosExitosos() {
        return registrosExitosos;
    }
    
    public void setRegistrosExitosos(Long registrosExitosos) {
        this.registrosExitosos = registrosExitosos;
    }
    
    public Long getRegistrosConError() {
        return registrosConError;
    }
    
    public void setRegistrosConError(Long registrosConError) {
        this.registrosConError = registrosConError;
    }
    
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getUsuarioSolicitante() {
        return usuarioSolicitante;
    }
    
    public void setUsuarioSolicitante(String usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }
}
