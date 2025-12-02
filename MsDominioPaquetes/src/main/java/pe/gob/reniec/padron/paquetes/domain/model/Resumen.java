package pe.gob.reniec.padron.paquetes.domain.model;

public class Resumen {
    private Long totalPaquetes;
    private Long paquetesAprobados;
    private Long paquetesPendientes;
    private Long paquetesEnRevision;
    private Double porcentajeAvance;

    public Resumen() {
    }

    public Resumen(Long totalPaquetes, Long paquetesAprobados, Long paquetesPendientes, 
                   Long paquetesEnRevision, Double porcentajeAvance) {
        this.totalPaquetes = totalPaquetes;
        this.paquetesAprobados = paquetesAprobados;
        this.paquetesPendientes = paquetesPendientes;
        this.paquetesEnRevision = paquetesEnRevision;
        this.porcentajeAvance = porcentajeAvance;
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

    public Long getPaquetesPendientes() {
        return paquetesPendientes;
    }

    public void setPaquetesPendientes(Long paquetesPendientes) {
        this.paquetesPendientes = paquetesPendientes;
    }

    public Long getPaquetesEnRevision() {
        return paquetesEnRevision;
    }

    public void setPaquetesEnRevision(Long paquetesEnRevision) {
        this.paquetesEnRevision = paquetesEnRevision;
    }

    public Double getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(Double porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }
}
