package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto;

public class DerivarTachaReclamoRequestDto {
    private String areaDestino;
    private String responsable;
    private String observaciones;

    public DerivarTachaReclamoRequestDto() {
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
