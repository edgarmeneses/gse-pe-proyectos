package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO - Data de la respuesta
 */
public class DataResponseDto {
    
    private String solicitudId;
    private String numeroSolicitud;
    private String estado;
    private String tipoTramite;
    private EntidadSolicitanteResponseDto entidadSolicitante;
    private String fechaRegistro;
    private String usuarioRegistro;
    private OficinaRegistroDto oficinaRegistro;
    private ResumenSolicitudDto resumenSolicitud;
    private List<SiguientePasoDto> siguientesPasos;
    private String urlSeguimiento;
    private List<EventoGeneradoDto> eventosGenerados;
    private LinksDto links;
    
    public DataResponseDto() {
    }
    
    public String getSolicitudId() {
        return solicitudId;
    }
    
    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }
    
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }
    
    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTipoTramite() {
        return tipoTramite;
    }
    
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    
    public EntidadSolicitanteResponseDto getEntidadSolicitante() {
        return entidadSolicitante;
    }
    
    public void setEntidadSolicitante(EntidadSolicitanteResponseDto entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
    }
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }
    
    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
    
    public OficinaRegistroDto getOficinaRegistro() {
        return oficinaRegistro;
    }
    
    public void setOficinaRegistro(OficinaRegistroDto oficinaRegistro) {
        this.oficinaRegistro = oficinaRegistro;
    }
    
    public ResumenSolicitudDto getResumenSolicitud() {
        return resumenSolicitud;
    }
    
    public void setResumenSolicitud(ResumenSolicitudDto resumenSolicitud) {
        this.resumenSolicitud = resumenSolicitud;
    }
    
    public List<SiguientePasoDto> getSiguientesPasos() {
        return siguientesPasos;
    }
    
    public void setSiguientesPasos(List<SiguientePasoDto> siguientesPasos) {
        this.siguientesPasos = siguientesPasos;
    }
    
    public String getUrlSeguimiento() {
        return urlSeguimiento;
    }
    
    public void setUrlSeguimiento(String urlSeguimiento) {
        this.urlSeguimiento = urlSeguimiento;
    }
    
    public List<EventoGeneradoDto> getEventosGenerados() {
        return eventosGenerados;
    }
    
    public void setEventosGenerados(List<EventoGeneradoDto> eventosGenerados) {
        this.eventosGenerados = eventosGenerados;
    }
    
    public LinksDto getLinks() {
        return links;
    }
    
    public void setLinks(LinksDto links) {
        this.links = links;
    }
}
