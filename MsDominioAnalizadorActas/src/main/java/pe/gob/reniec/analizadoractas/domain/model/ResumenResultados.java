package pe.gob.reniec.analizadoractas.domain.model;

/**
 * Value Object: Representa el resumen consolidado de los resultados del análisis
 */
public class ResumenResultados {

    private Integer totalActasAnalizadas;
    private Integer actasConAlertasAltas;
    private Integer actasConAlertasMedias;
    private Integer actasConAlertasBajas;
    private Integer actasSinInconsistencias;
    private Double tiempoProcesamientoSegundos;

    public ResumenResultados() {
    }

    public ResumenResultados(Integer totalActasAnalizadas, Integer actasConAlertasAltas,
                             Integer actasConAlertasMedias, Integer actasConAlertasBajas,
                             Integer actasSinInconsistencias, Double tiempoProcesamientoSegundos) {
        this.totalActasAnalizadas = totalActasAnalizadas;
        this.actasConAlertasAltas = actasConAlertasAltas;
        this.actasConAlertasMedias = actasConAlertasMedias;
        this.actasConAlertasBajas = actasConAlertasBajas;
        this.actasSinInconsistencias = actasSinInconsistencias;
        this.tiempoProcesamientoSegundos = tiempoProcesamientoSegundos;
    }

    public Integer getTotalActasAnalizadas() {
        return totalActasAnalizadas;
    }

    public void setTotalActasAnalizadas(Integer totalActasAnalizadas) {
        this.totalActasAnalizadas = totalActasAnalizadas;
    }

    public Integer getActasConAlertasAltas() {
        return actasConAlertasAltas;
    }

    public void setActasConAlertasAltas(Integer actasConAlertasAltas) {
        this.actasConAlertasAltas = actasConAlertasAltas;
    }

    public Integer getActasConAlertasMedias() {
        return actasConAlertasMedias;
    }

    public void setActasConAlertasMedias(Integer actasConAlertasMedias) {
        this.actasConAlertasMedias = actasConAlertasMedias;
    }

    public Integer getActasConAlertasBajas() {
        return actasConAlertasBajas;
    }

    public void setActasConAlertasBajas(Integer actasConAlertasBajas) {
        this.actasConAlertasBajas = actasConAlertasBajas;
    }

    public Integer getActasSinInconsistencias() {
        return actasSinInconsistencias;
    }

    public void setActasSinInconsistencias(Integer actasSinInconsistencias) {
        this.actasSinInconsistencias = actasSinInconsistencias;
    }

    public Double getTiempoProcesamientoSegundos() {
        return tiempoProcesamientoSegundos;
    }

    public void setTiempoProcesamientoSegundos(Double tiempoProcesamientoSegundos) {
        this.tiempoProcesamientoSegundos = tiempoProcesamientoSegundos;
    }
}
