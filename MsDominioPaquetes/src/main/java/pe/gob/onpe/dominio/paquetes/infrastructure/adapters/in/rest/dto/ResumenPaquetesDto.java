package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class ResumenPaquetesDto {
    private Integer totalPaquetes;
    private Integer paquetesAprobados;
    private Integer paquetesPendientes;
    private Integer paquetesEnRevision;
    private Double porcentajeAvance;
    private Double porcentajeAprobacion;

    public ResumenPaquetesDto() {
    }

    public Integer getTotalPaquetes() {
        return totalPaquetes;
    }

    public void setTotalPaquetes(Integer totalPaquetes) {
        this.totalPaquetes = totalPaquetes;
    }

    public Integer getPaquetesAprobados() {
        return paquetesAprobados;
    }

    public void setPaquetesAprobados(Integer paquetesAprobados) {
        this.paquetesAprobados = paquetesAprobados;
    }

    public Integer getPaquetesPendientes() {
        return paquetesPendientes;
    }

    public void setPaquetesPendientes(Integer paquetesPendientes) {
        this.paquetesPendientes = paquetesPendientes;
    }

    public Integer getPaquetesEnRevision() {
        return paquetesEnRevision;
    }

    public void setPaquetesEnRevision(Integer paquetesEnRevision) {
        this.paquetesEnRevision = paquetesEnRevision;
    }

    public Double getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(Double porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public Double getPorcentajeAprobacion() {
        return porcentajeAprobacion;
    }

    public void setPorcentajeAprobacion(Double porcentajeAprobacion) {
        this.porcentajeAprobacion = porcentajeAprobacion;
    }
}
