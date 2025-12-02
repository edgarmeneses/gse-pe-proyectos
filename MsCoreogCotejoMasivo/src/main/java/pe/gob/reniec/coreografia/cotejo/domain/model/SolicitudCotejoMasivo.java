package pe.gob.reniec.coreografia.cotejo.domain.model;

import java.util.List;

public class SolicitudCotejoMasivo {
    private Solicitud solicitud;
    private EntidadSolicitante entidadSolicitante;
    private List<RegistroCotejo> registrosCotejo;
    private ConfiguracionProceso configuracionProceso;
    private DocumentoSolicitud documentoSolicitud;
    private String observaciones;

    public SolicitudCotejoMasivo() {
    }

    public SolicitudCotejoMasivo(Solicitud solicitud, EntidadSolicitante entidadSolicitante, 
                                  List<RegistroCotejo> registrosCotejo, ConfiguracionProceso configuracionProceso, 
                                  DocumentoSolicitud documentoSolicitud, String observaciones) {
        this.solicitud = solicitud;
        this.entidadSolicitante = entidadSolicitante;
        this.registrosCotejo = registrosCotejo;
        this.configuracionProceso = configuracionProceso;
        this.documentoSolicitud = documentoSolicitud;
        this.observaciones = observaciones;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public EntidadSolicitante getEntidadSolicitante() {
        return entidadSolicitante;
    }

    public void setEntidadSolicitante(EntidadSolicitante entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
    }

    public List<RegistroCotejo> getRegistrosCotejo() {
        return registrosCotejo;
    }

    public void setRegistrosCotejo(List<RegistroCotejo> registrosCotejo) {
        this.registrosCotejo = registrosCotejo;
    }

    public ConfiguracionProceso getConfiguracionProceso() {
        return configuracionProceso;
    }

    public void setConfiguracionProceso(ConfiguracionProceso configuracionProceso) {
        this.configuracionProceso = configuracionProceso;
    }

    public DocumentoSolicitud getDocumentoSolicitud() {
        return documentoSolicitud;
    }

    public void setDocumentoSolicitud(DocumentoSolicitud documentoSolicitud) {
        this.documentoSolicitud = documentoSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
