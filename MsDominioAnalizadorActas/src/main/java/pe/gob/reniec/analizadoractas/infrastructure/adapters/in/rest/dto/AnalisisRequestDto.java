package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

/**
 * DTO de entrada: Solicitud completa de análisis de actas
 */
public class AnalisisRequestDto {

    private SolicitudAnalisisDto solicitudAnalisis;
    private UsuarioSolicitanteDto usuarioSolicitante;
    private String prioridadAnalisis;

    public AnalisisRequestDto() {
    }

    public AnalisisRequestDto(SolicitudAnalisisDto solicitudAnalisis,
                              UsuarioSolicitanteDto usuarioSolicitante,
                              String prioridadAnalisis) {
        this.solicitudAnalisis = solicitudAnalisis;
        this.usuarioSolicitante = usuarioSolicitante;
        this.prioridadAnalisis = prioridadAnalisis;
    }

    public SolicitudAnalisisDto getSolicitudAnalisis() {
        return solicitudAnalisis;
    }

    public void setSolicitudAnalisis(SolicitudAnalisisDto solicitudAnalisis) {
        this.solicitudAnalisis = solicitudAnalisis;
    }

    public UsuarioSolicitanteDto getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(UsuarioSolicitanteDto usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public String getPrioridadAnalisis() {
        return prioridadAnalisis;
    }

    public void setPrioridadAnalisis(String prioridadAnalisis) {
        this.prioridadAnalisis = prioridadAnalisis;
    }
}
