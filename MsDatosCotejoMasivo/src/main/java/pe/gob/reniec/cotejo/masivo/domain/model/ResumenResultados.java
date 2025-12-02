package pe.gob.reniec.cotejo.masivo.domain.model;

public class ResumenResultados {
    private Integer totalCorrectos;
    private Integer totalIncorrectos;
    private Integer totalNoEncontrados;
    private Integer totalFallecidos;
    private Integer totalRestringidos;
    private Integer totalCaducados;
    private Integer totalErrores;

    public ResumenResultados() {
    }

    public Integer getTotalCorrectos() {
        return totalCorrectos;
    }

    public void setTotalCorrectos(Integer totalCorrectos) {
        this.totalCorrectos = totalCorrectos;
    }

    public Integer getTotalIncorrectos() {
        return totalIncorrectos;
    }

    public void setTotalIncorrectos(Integer totalIncorrectos) {
        this.totalIncorrectos = totalIncorrectos;
    }

    public Integer getTotalNoEncontrados() {
        return totalNoEncontrados;
    }

    public void setTotalNoEncontrados(Integer totalNoEncontrados) {
        this.totalNoEncontrados = totalNoEncontrados;
    }

    public Integer getTotalFallecidos() {
        return totalFallecidos;
    }

    public void setTotalFallecidos(Integer totalFallecidos) {
        this.totalFallecidos = totalFallecidos;
    }

    public Integer getTotalRestringidos() {
        return totalRestringidos;
    }

    public void setTotalRestringidos(Integer totalRestringidos) {
        this.totalRestringidos = totalRestringidos;
    }

    public Integer getTotalCaducados() {
        return totalCaducados;
    }

    public void setTotalCaducados(Integer totalCaducados) {
        this.totalCaducados = totalCaducados;
    }

    public Integer getTotalErrores() {
        return totalErrores;
    }

    public void setTotalErrores(Integer totalErrores) {
        this.totalErrores = totalErrores;
    }
}
