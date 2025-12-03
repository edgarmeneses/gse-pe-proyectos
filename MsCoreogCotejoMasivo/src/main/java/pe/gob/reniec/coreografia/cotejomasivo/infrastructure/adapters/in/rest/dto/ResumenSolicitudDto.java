package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Resumen de Solicitud
 */
public class ResumenSolicitudDto {
    
    private Integer totalRegistros;
    private String prioridad;
    private String tiempoEstimadoProcesamiento;
    
    public ResumenSolicitudDto() {
    }
    
    public Integer getTotalRegistros() {
        return totalRegistros;
    }
    
    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    
    public String getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
    public String getTiempoEstimadoProcesamiento() {
        return tiempoEstimadoProcesamiento;
    }
    
    public void setTiempoEstimadoProcesamiento(String tiempoEstimadoProcesamiento) {
        this.tiempoEstimadoProcesamiento = tiempoEstimadoProcesamiento;
    }
}
