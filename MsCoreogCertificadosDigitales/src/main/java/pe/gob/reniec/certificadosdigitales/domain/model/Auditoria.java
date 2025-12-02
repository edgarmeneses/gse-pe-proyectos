package pe.gob.reniec.certificadosdigitales.domain.model;

public class Auditoria {
    private String registroAuditoriaId;
    private String usuarioEjecutor;
    private String oficinaEjecucion;
    private String ipCliente;

    public Auditoria() {
    }

    public Auditoria(String registroAuditoriaId, String usuarioEjecutor, String oficinaEjecucion, String ipCliente) {
        this.registroAuditoriaId = registroAuditoriaId;
        this.usuarioEjecutor = usuarioEjecutor;
        this.oficinaEjecucion = oficinaEjecucion;
        this.ipCliente = ipCliente;
    }

    public String getRegistroAuditoriaId() {
        return registroAuditoriaId;
    }

    public void setRegistroAuditoriaId(String registroAuditoriaId) {
        this.registroAuditoriaId = registroAuditoriaId;
    }

    public String getUsuarioEjecutor() {
        return usuarioEjecutor;
    }

    public void setUsuarioEjecutor(String usuarioEjecutor) {
        this.usuarioEjecutor = usuarioEjecutor;
    }

    public String getOficinaEjecucion() {
        return oficinaEjecucion;
    }

    public void setOficinaEjecucion(String oficinaEjecucion) {
        this.oficinaEjecucion = oficinaEjecucion;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }
}
