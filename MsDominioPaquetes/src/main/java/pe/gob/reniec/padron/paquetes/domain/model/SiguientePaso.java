package pe.gob.reniec.padron.paquetes.domain.model;

public class SiguientePaso {
    private String accion;
    private String descripcion;
    private String plantillaSugerida;

    public SiguientePaso() {
    }

    public SiguientePaso(String accion, String descripcion, String plantillaSugerida) {
        this.accion = accion;
        this.descripcion = descripcion;
        this.plantillaSugerida = plantillaSugerida;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlantillaSugerida() {
        return plantillaSugerida;
    }

    public void setPlantillaSugerida(String plantillaSugerida) {
        this.plantillaSugerida = plantillaSugerida;
    }
}
