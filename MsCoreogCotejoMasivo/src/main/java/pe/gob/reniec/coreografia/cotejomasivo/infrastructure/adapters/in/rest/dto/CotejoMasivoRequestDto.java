package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO - Request para iniciar cotejo masivo
 */
public class CotejoMasivoRequestDto {
    
    private SolicitudDto solicitud;
    private EntidadSolicitanteDto entidadSolicitante;
    private List<RegistroCotejoDto> registrosCotejo;
    private ConfiguracionProcesoDto configuracionProceso;
    private DocumentoSolicitudDto documentoSolicitud;
    private String observaciones;
    
    public CotejoMasivoRequestDto() {
    }
    
    public SolicitudDto getSolicitud() {
        return solicitud;
    }
    
    public void setSolicitud(SolicitudDto solicitud) {
        this.solicitud = solicitud;
    }
    
    public EntidadSolicitanteDto getEntidadSolicitante() {
        return entidadSolicitante;
    }
    
    public void setEntidadSolicitante(EntidadSolicitanteDto entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
    }
    
    public List<RegistroCotejoDto> getRegistrosCotejo() {
        return registrosCotejo;
    }
    
    public void setRegistrosCotejo(List<RegistroCotejoDto> registrosCotejo) {
        this.registrosCotejo = registrosCotejo;
    }
    
    public ConfiguracionProcesoDto getConfiguracionProceso() {
        return configuracionProceso;
    }
    
    public void setConfiguracionProceso(ConfiguracionProcesoDto configuracionProceso) {
        this.configuracionProceso = configuracionProceso;
    }
    
    public DocumentoSolicitudDto getDocumentoSolicitud() {
        return documentoSolicitud;
    }
    
    public void setDocumentoSolicitud(DocumentoSolicitudDto documentoSolicitud) {
        this.documentoSolicitud = documentoSolicitud;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
