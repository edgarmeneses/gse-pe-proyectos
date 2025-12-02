package pe.gob.reniec.protecciondocumentos.domain.model;

public class EstadisticasCompresion {
    private String algoritmo;
    private String nivelCompresion;
    private int tamanioOriginal;
    private int tamanioComprimido;
    private float ratioCompresion;

    public EstadisticasCompresion() {
    }

    public EstadisticasCompresion(String algoritmo, String nivelCompresion, int tamanioOriginal, 
                                 int tamanioComprimido, float ratioCompresion) {
        this.algoritmo = algoritmo;
        this.nivelCompresion = nivelCompresion;
        this.tamanioOriginal = tamanioOriginal;
        this.tamanioComprimido = tamanioComprimido;
        this.ratioCompresion = ratioCompresion;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getNivelCompresion() {
        return nivelCompresion;
    }

    public void setNivelCompresion(String nivelCompresion) {
        this.nivelCompresion = nivelCompresion;
    }

    public int getTamanioOriginal() {
        return tamanioOriginal;
    }

    public void setTamanioOriginal(int tamanioOriginal) {
        this.tamanioOriginal = tamanioOriginal;
    }

    public int getTamanioComprimido() {
        return tamanioComprimido;
    }

    public void setTamanioComprimido(int tamanioComprimido) {
        this.tamanioComprimido = tamanioComprimido;
    }

    public float getRatioCompresion() {
        return ratioCompresion;
    }

    public void setRatioCompresion(float ratioCompresion) {
        this.ratioCompresion = ratioCompresion;
    }
}
