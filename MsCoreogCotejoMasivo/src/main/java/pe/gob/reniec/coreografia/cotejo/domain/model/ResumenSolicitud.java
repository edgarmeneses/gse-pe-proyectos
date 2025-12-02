package pe.gob.reniec.coreografia.cotejo.domain.model;

public class ResumenSolicitud {
    private Long totalRegistros;
    private String prioridad;
    private String tiempoEstimadoProcesamiento;

    public ResumenSolicitud() {
    }

    public ResumenSolicitud(Long totalRegistros, String prioridad, String tiempoEstimadoProcesamiento) {
        this.totalRegistros = totalRegistros;
        this.prioridad = prioridad;
        this.tiempoEstimadoProcesamiento = tiempoEstimadoProcesamiento;
    }

    public Long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Long totalRegistros) {
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
