package pe.gob.reniec.protecciondocumentos.domain.model;

public class ResultadoSeguridad {
    private AlgoritmoCifrado algoritmoCifrado;
    private NivelSeguridad nivelSeguridad;

    public ResultadoSeguridad() {
    }

    public ResultadoSeguridad(AlgoritmoCifrado algoritmoCifrado, NivelSeguridad nivelSeguridad) {
        this.algoritmoCifrado = algoritmoCifrado;
        this.nivelSeguridad = nivelSeguridad;
    }

    public AlgoritmoCifrado getAlgoritmoCifrado() {
        return algoritmoCifrado;
    }

    public void setAlgoritmoCifrado(AlgoritmoCifrado algoritmoCifrado) {
        this.algoritmoCifrado = algoritmoCifrado;
    }

    public NivelSeguridad getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(NivelSeguridad nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }
}
