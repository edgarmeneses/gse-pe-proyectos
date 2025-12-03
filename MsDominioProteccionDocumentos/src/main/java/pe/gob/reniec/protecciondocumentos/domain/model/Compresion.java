package pe.gob.reniec.protecciondocumentos.domain.model;

public class Compresion {
    private NivelCompresion nivel;
    private String formato;
    private Long tamanioOriginalBytes;
    private Long tamanioComprimidoBytes;
    private Double ratioCompresion;

    public Compresion() {
    }

    public Compresion(NivelCompresion nivel, String formato, Long tamanioOriginalBytes, 
                     Long tamanioComprimidoBytes, Double ratioCompresion) {
        this.nivel = nivel;
        this.formato = formato;
        this.tamanioOriginalBytes = tamanioOriginalBytes;
        this.tamanioComprimidoBytes = tamanioComprimidoBytes;
        this.ratioCompresion = ratioCompresion;
    }

    public NivelCompresion getNivel() {
        return nivel;
    }

    public void setNivel(NivelCompresion nivel) {
        this.nivel = nivel;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Long getTamanioOriginalBytes() {
        return tamanioOriginalBytes;
    }

    public void setTamanioOriginalBytes(Long tamanioOriginalBytes) {
        this.tamanioOriginalBytes = tamanioOriginalBytes;
    }

    public Long getTamanioComprimidoBytes() {
        return tamanioComprimidoBytes;
    }

    public void setTamanioComprimidoBytes(Long tamanioComprimidoBytes) {
        this.tamanioComprimidoBytes = tamanioComprimidoBytes;
    }

    public Double getRatioCompresion() {
        return ratioCompresion;
    }

    public void setRatioCompresion(Double ratioCompresion) {
        this.ratioCompresion = ratioCompresion;
    }
}
