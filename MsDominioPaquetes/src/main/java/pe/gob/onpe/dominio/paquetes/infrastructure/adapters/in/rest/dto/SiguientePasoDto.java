package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class SiguientePasoDto {
    private String accion;
    private String descripcion;
    private String plantillaSugerida;

    public SiguientePasoDto() {
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
