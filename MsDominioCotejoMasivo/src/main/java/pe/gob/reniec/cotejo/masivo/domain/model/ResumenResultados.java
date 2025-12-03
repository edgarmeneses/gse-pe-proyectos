package pe.gob.reniec.cotejo.masivo.domain.model;

public class ResumenResultados {
    private Long totalCorrectos;
    private Long totalDniNoExiste;
    private Long totalDatosNoCoinciden;
    private Long totalErrores;
    private Double porcentajeExito;

    public ResumenResultados() {
    }

    public ResumenResultados(Long totalCorrectos, Long totalDniNoExiste, 
                            Long totalDatosNoCoinciden, Long totalErrores) {
        this.totalCorrectos = totalCorrectos;
        this.totalDniNoExiste = totalDniNoExiste;
        this.totalDatosNoCoinciden = totalDatosNoCoinciden;
        this.totalErrores = totalErrores;
        this.calcularPorcentajeExito();
    }

    public Long getTotalCorrectos() {
        return totalCorrectos;
    }

    public void setTotalCorrectos(Long totalCorrectos) {
        this.totalCorrectos = totalCorrectos;
        this.calcularPorcentajeExito();
    }

    public Long getTotalDniNoExiste() {
        return totalDniNoExiste;
    }

    public void setTotalDniNoExiste(Long totalDniNoExiste) {
        this.totalDniNoExiste = totalDniNoExiste;
        this.calcularPorcentajeExito();
    }

    public Long getTotalDatosNoCoinciden() {
        return totalDatosNoCoinciden;
    }

    public void setTotalDatosNoCoinciden(Long totalDatosNoCoinciden) {
        this.totalDatosNoCoinciden = totalDatosNoCoinciden;
        this.calcularPorcentajeExito();
    }

    public Long getTotalErrores() {
        return totalErrores;
    }

    public void setTotalErrores(Long totalErrores) {
        this.totalErrores = totalErrores;
        this.calcularPorcentajeExito();
    }

    public Double getPorcentajeExito() {
        return porcentajeExito;
    }

    private void calcularPorcentajeExito() {
        long total = (totalCorrectos != null ? totalCorrectos : 0L) +
                     (totalDniNoExiste != null ? totalDniNoExiste : 0L) +
                     (totalDatosNoCoinciden != null ? totalDatosNoCoinciden : 0L) +
                     (totalErrores != null ? totalErrores : 0L);
        
        if (total > 0) {
            this.porcentajeExito = ((totalCorrectos != null ? totalCorrectos : 0L) * 100.0) / total;
        } else {
            this.porcentajeExito = 0.0;
        }
    }
}
