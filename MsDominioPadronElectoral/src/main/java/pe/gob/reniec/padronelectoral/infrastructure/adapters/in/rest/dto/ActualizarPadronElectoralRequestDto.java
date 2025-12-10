package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto;

public class ActualizarPadronElectoralRequestDto {
    private String usuarioResponsableId;
    private String tipoPadron;
    private String informeFinalVerificacionDomicilioId;
    private String tipoVerificacion;

    public ActualizarPadronElectoralRequestDto() {
    }

    public String getUsuarioResponsableId() {
        return usuarioResponsableId;
    }

    public void setUsuarioResponsableId(String usuarioResponsableId) {
        this.usuarioResponsableId = usuarioResponsableId;
    }

    public String getTipoPadron() {
        return tipoPadron;
    }

    public void setTipoPadron(String tipoPadron) {
        this.tipoPadron = tipoPadron;
    }

    public String getInformeFinalVerificacionDomicilioId() {
        return informeFinalVerificacionDomicilioId;
    }

    public void setInformeFinalVerificacionDomicilioId(String informeFinalVerificacionDomicilioId) {
        this.informeFinalVerificacionDomicilioId = informeFinalVerificacionDomicilioId;
    }

    public String getTipoVerificacion() {
        return tipoVerificacion;
    }

    public void setTipoVerificacion(String tipoVerificacion) {
        this.tipoVerificacion = tipoVerificacion;
    }
}
