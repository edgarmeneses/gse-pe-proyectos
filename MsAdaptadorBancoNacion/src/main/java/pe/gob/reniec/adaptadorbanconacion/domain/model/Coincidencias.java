package pe.gob.reniec.adaptadorbanconacion.domain.model;

public class Coincidencias {

    private Boolean montoCoincide;
    private Double diferenciaMonto;
    private Boolean fechaCoincide;
    private Integer diasDiferencia;

    public Coincidencias() {
    }

    public Coincidencias(Boolean montoCoincide, Double diferenciaMonto, Boolean fechaCoincide,
                        Integer diasDiferencia) {
        this.montoCoincide = montoCoincide;
        this.diferenciaMonto = diferenciaMonto;
        this.fechaCoincide = fechaCoincide;
        this.diasDiferencia = diasDiferencia;
    }

    public Boolean getMontoCoincide() {
        return montoCoincide;
    }

    public void setMontoCoincide(Boolean montoCoincide) {
        this.montoCoincide = montoCoincide;
    }

    public Double getDiferenciaMonto() {
        return diferenciaMonto;
    }

    public void setDiferenciaMonto(Double diferenciaMonto) {
        this.diferenciaMonto = diferenciaMonto;
    }

    public Boolean getFechaCoincide() {
        return fechaCoincide;
    }

    public void setFechaCoincide(Boolean fechaCoincide) {
        this.fechaCoincide = fechaCoincide;
    }

    public Integer getDiasDiferencia() {
        return diasDiferencia;
    }

    public void setDiasDiferencia(Integer diasDiferencia) {
        this.diasDiferencia = diasDiferencia;
    }
}
