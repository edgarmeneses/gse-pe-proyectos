package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para el paso 1 de generación de claves
 */
public class Paso1GeneracionClavesDto {
    
    private String estado;
    private String solicitudPkiId;
    private String fechaInicio;
    private String fechaFin;
    private Integer intentos;
    
    public Paso1GeneracionClavesDto() {
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getSolicitudPkiId() {
        return solicitudPkiId;
    }
    
    public void setSolicitudPkiId(String solicitudPkiId) {
        this.solicitudPkiId = solicitudPkiId;
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
