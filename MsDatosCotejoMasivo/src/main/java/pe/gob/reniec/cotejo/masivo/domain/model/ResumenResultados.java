package pe.gob.reniec.cotejo.masivo.domain.model;

public class ResumenResultados {
    private Long totalCorrectos;
    private Long totalIncorrectos;
    private Long totalNoEncontrados;
    private Long totalFallecidos;
    private Long totalRestringidos;
    private Long totalCaducados;
    private Long totalErrores;

    public ResumenResultados() {
    }

    public ResumenResultados(Long totalCorrectos, Long totalIncorrectos, Long totalNoEncontrados,
                             Long totalFallecidos, Long totalRestringidos, Long totalCaducados, Long totalErrores) {
        this.totalCorrectos = totalCorrectos;
        this.totalIncorrectos = totalIncorrectos;
        this.totalNoEncontrados = totalNoEncontrados;
        this.totalFallecidos = totalFallecidos;
        this.totalRestringidos = totalRestringidos;
        this.totalCaducados = totalCaducados;
        this.totalErrores = totalErrores;
    }

    public Long getTotalCorrectos() {
        return totalCorrectos;
    }

    public void setTotalCorrectos(Long totalCorrectos) {
        this.totalCorrectos = totalCorrectos;
    }

    public Long getTotalIncorrectos() {
        return totalIncorrectos;
    }

    public void setTotalIncorrectos(Long totalIncorrectos) {
        this.totalIncorrectos = totalIncorrectos;
    }

    public Long getTotalNoEncontrados() {
        return totalNoEncontrados;
    }

    public void setTotalNoEncontrados(Long totalNoEncontrados) {
        this.totalNoEncontrados = totalNoEncontrados;
    }

    public Long getTotalFallecidos() {
        return totalFallecidos;
    }

    public void setTotalFallecidos(Long totalFallecidos) {
        this.totalFallecidos = totalFallecidos;
    }

    public Long getTotalRestringidos() {
        return totalRestringidos;
    }

    public void setTotalRestringidos(Long totalRestringidos) {
        this.totalRestringidos = totalRestringidos;
    }

    public Long getTotalCaducados() {
        return totalCaducados;
    }

    public void setTotalCaducados(Long totalCaducados) {
        this.totalCaducados = totalCaducados;
    }

    public Long getTotalErrores() {
        return totalErrores;
    }

    public void setTotalErrores(Long totalErrores) {
        this.totalErrores = totalErrores;
    }
}
