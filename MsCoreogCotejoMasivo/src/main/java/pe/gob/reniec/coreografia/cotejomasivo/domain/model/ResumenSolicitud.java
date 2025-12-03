package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Resumen de información de la solicitud
 */
public class ResumenSolicitud {
    
    private Integer totalRegistros;
    private String prioridad;
    private String tiempoEstimadoProcesamiento;
    
    public ResumenSolicitud() {
    }
    
    public ResumenSolicitud(Integer totalRegistros, String prioridad, String tiempoEstimadoProcesamiento) {
        this.totalRegistros = totalRegistros;
        this.prioridad = prioridad;
        this.tiempoEstimadoProcesamiento = tiempoEstimadoProcesamiento;
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
