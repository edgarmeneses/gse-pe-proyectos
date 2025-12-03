package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para el paso 2 de emisión de certificado
 */
public class Paso2EmisionCertificadoDto {
    
    private String estado;
    private String fechaInicio;
    private String fechaFin;
    private Integer intentos;
    
    public Paso2EmisionCertificadoDto() {
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
    
    public Integer getIntentos() {
        return intentos;
    }
    
    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }
}
