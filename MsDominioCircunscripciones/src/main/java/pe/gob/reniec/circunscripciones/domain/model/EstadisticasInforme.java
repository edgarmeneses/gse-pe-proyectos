package pe.gob.reniec.circunscripciones.domain.model;

public class EstadisticasInforme {

    private Integer totalPoblacionObjetivo;
    private Integer totalVerificados;
    private Integer totalPendientes;
    private Double porcentajeAvance;
    private Integer situacionA;
    private Integer situacionB;
    private Integer situacionC;
    private Integer conDescargos;
    private Integer descargosAceptados;
    private Integer descargosRechazados;

    public EstadisticasInforme() {
    }

    public EstadisticasInforme(Integer totalPoblacionObjetivo, Integer totalVerificados,
                               Integer totalPendientes, Double porcentajeAvance, Integer situacionA,
                               Integer situacionB, Integer situacionC, Integer conDescargos,
                               Integer descargosAceptados, Integer descargosRechazados) {
        this.totalPoblacionObjetivo = totalPoblacionObjetivo;
        this.totalVerificados = totalVerificados;
        this.totalPendientes = totalPendientes;
        this.porcentajeAvance = porcentajeAvance;
        this.situacionA = situacionA;
        this.situacionB = situacionB;
        this.situacionC = situacionC;
        this.conDescargos = conDescargos;
        this.descargosAceptados = descargosAceptados;
        this.descargosRechazados = descargosRechazados;
    }

    public Integer getTotalPoblacionObjetivo() {
        return totalPoblacionObjetivo;
    }

    public void setTotalPoblacionObjetivo(Integer totalPoblacionObjetivo) {
        this.totalPoblacionObjetivo = totalPoblacionObjetivo;
    }

    public Integer getTotalVerificados() {
        return totalVerificados;
    }

    public void setTotalVerificados(Integer totalVerificados) {
        this.totalVerificados = totalVerificados;
    }

    public Integer getTotalPendientes() {
        return totalPendientes;
    }

    public void setTotalPendientes(Integer totalPendientes) {
        this.totalPendientes = totalPendientes;
    }

    public Double getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(Double porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public Integer getSituacionA() {
        return situacionA;
    }

    public void setSituacionA(Integer situacionA) {
        this.situacionA = situacionA;
    }

    public Integer getSituacionB() {
        return situacionB;
    }

    public void setSituacionB(Integer situacionB) {
        this.situacionB = situacionB;
    }

    public Integer getSituacionC() {
        return situacionC;
    }

    public void setSituacionC(Integer situacionC) {
        this.situacionC = situacionC;
    }

    public Integer getConDescargos() {
        return conDescargos;
    }

    public void setConDescargos(Integer conDescargos) {
        this.conDescargos = conDescargos;
    }

    public Integer getDescargosAceptados() {
        return descargosAceptados;
    }

    public void setDescargosAceptados(Integer descargosAceptados) {
        this.descargosAceptados = descargosAceptados;
    }

    public Integer getDescargosRechazados() {
        return descargosRechazados;
    }

    public void setDescargosRechazados(Integer descargosRechazados) {
        this.descargosRechazados = descargosRechazados;
    }
}
