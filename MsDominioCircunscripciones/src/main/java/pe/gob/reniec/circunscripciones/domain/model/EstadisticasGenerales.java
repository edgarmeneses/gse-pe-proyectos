package pe.gob.reniec.circunscripciones.domain.model;

public class EstadisticasGenerales {

    private Integer totalCambiosDomicilio;
    private Integer totalCircunscripcionesAfectadas;
    private Integer totalPoblacionVerificar;
    private Double promedioCambiosPorCircunscripcion;

    public EstadisticasGenerales() {
    }

    public EstadisticasGenerales(Integer totalCambiosDomicilio, Integer totalCircunscripcionesAfectadas,
                                 Integer totalPoblacionVerificar, Double promedioCambiosPorCircunscripcion) {
        this.totalCambiosDomicilio = totalCambiosDomicilio;
        this.totalCircunscripcionesAfectadas = totalCircunscripcionesAfectadas;
        this.totalPoblacionVerificar = totalPoblacionVerificar;
        this.promedioCambiosPorCircunscripcion = promedioCambiosPorCircunscripcion;
    }

    public Integer getTotalCambiosDomicilio() {
        return totalCambiosDomicilio;
    }

    public void setTotalCambiosDomicilio(Integer totalCambiosDomicilio) {
        this.totalCambiosDomicilio = totalCambiosDomicilio;
    }

    public Integer getTotalCircunscripcionesAfectadas() {
        return totalCircunscripcionesAfectadas;
    }

    public void setTotalCircunscripcionesAfectadas(Integer totalCircunscripcionesAfectadas) {
        this.totalCircunscripcionesAfectadas = totalCircunscripcionesAfectadas;
    }

    public Integer getTotalPoblacionVerificar() {
        return totalPoblacionVerificar;
    }

    public void setTotalPoblacionVerificar(Integer totalPoblacionVerificar) {
        this.totalPoblacionVerificar = totalPoblacionVerificar;
    }

    public Double getPromedioCambiosPorCircunscripcion() {
        return promedioCambiosPorCircunscripcion;
    }

    public void setPromedioCambiosPorCircunscripcion(Double promedioCambiosPorCircunscripcion) {
        this.promedioCambiosPorCircunscripcion = promedioCambiosPorCircunscripcion;
    }
}
