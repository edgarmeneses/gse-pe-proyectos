package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class ResultadoValidacionDto {
    private Boolean esValido;
    private String resumenValidacion;
    private Integer firmasEncontradas;
    private Integer firmasValidas;
    private Integer firmasInvalidas;

    public ResultadoValidacionDto() {}

    public Boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(Boolean esValido) {
        this.esValido = esValido;
    }

    public String getResumenValidacion() {
        return resumenValidacion;
    }

    public void setResumenValidacion(String resumenValidacion) {
        this.resumenValidacion = resumenValidacion;
    }

    public Integer getFirmasEncontradas() {
        return firmasEncontradas;
    }

    public void setFirmasEncontradas(Integer firmasEncontradas) {
        this.firmasEncontradas = firmasEncontradas;
    }

    public Integer getFirmasValidas() {
        return firmasValidas;
    }

    public void setFirmasValidas(Integer firmasValidas) {
        this.firmasValidas = firmasValidas;
    }

    public Integer getFirmasInvalidas() {
        return firmasInvalidas;
    }

    public void setFirmasInvalidas(Integer firmasInvalidas) {
        this.firmasInvalidas = firmasInvalidas;
    }
}
