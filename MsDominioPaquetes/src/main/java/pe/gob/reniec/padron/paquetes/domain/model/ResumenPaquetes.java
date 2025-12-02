package pe.gob.reniec.padron.paquetes.domain.model;

public class ResumenPaquetes {
    private Long totalPaquetes;
    private Long paquetesAprobados;
    private Double porcentajeAprobacion;

    public ResumenPaquetes() {
    }

    public ResumenPaquetes(Long totalPaquetes, Long paquetesAprobados, Double porcentajeAprobacion) {
        this.totalPaquetes = totalPaquetes;
        this.paquetesAprobados = paquetesAprobados;
        this.porcentajeAprobacion = porcentajeAprobacion;
    }

    public Long getTotalPaquetes() {
        return totalPaquetes;
    }

    public void setTotalPaquetes(Long totalPaquetes) {
        this.totalPaquetes = totalPaquetes;
    }

    public Long getPaquetesAprobados() {
        return paquetesAprobados;
    }

    public void setPaquetesAprobados(Long paquetesAprobados) {
        this.paquetesAprobados = paquetesAprobados;
    }

    public Double getPorcentajeAprobacion() {
        return porcentajeAprobacion;
    }

    public void setPorcentajeAprobacion(Double porcentajeAprobacion) {
        this.porcentajeAprobacion = porcentajeAprobacion;
    }
}
