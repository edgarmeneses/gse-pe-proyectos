package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información de auditoría
 */
public class AuditoriaDto {
    
    private String registroAuditoriaId;
    private String usuarioEjecutor;
    private String oficinaEjecucion;
    private String ipCliente;
    
    public AuditoriaDto() {
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
