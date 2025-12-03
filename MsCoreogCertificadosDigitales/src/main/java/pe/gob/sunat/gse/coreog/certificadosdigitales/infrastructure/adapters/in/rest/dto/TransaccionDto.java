package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información de la transacción
 */
public class TransaccionDto {
    
    private String transaccionId;
    private String codigoSolicitudTramite;
    private String estado;
    private String fechaInicio;
    private String fechaFin;
    private Integer tiempoProcesamientoMs;
    
    public TransaccionDto() {
    }
    
    public String getTransaccionId() {
        return transaccionId;
    }
    
    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }
    
    public String getCodigoSolicitudTramite() {
        return codigoSolicitudTramite;
    }
    
    public void setCodigoSolicitudTramite(String codigoSolicitudTramite) {
        this.codigoSolicitudTramite = codigoSolicitudTramite;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public String getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }
    
    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }
}
