package pe.gob.pj.solicitudes.data.domain.model;

public class RequisitoCumplido {
    
    private String requisitoId;
    private String nombreRequisito;
    private Boolean cumple;
    private String observacion;

    public RequisitoCumplido() {
    }

    public RequisitoCumplido(String requisitoId, String nombreRequisito, Boolean cumple, String observacion) {
        this.requisitoId = requisitoId;
        this.nombreRequisito = nombreRequisito;
        this.cumple = cumple;
        this.observacion = observacion;
    }

    public String getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(String requisitoId) {
        this.requisitoId = requisitoId;
    }

    public String getNombreRequisito() {
        return nombreRequisito;
    }

    public void setNombreRequisito(String nombreRequisito) {
        this.nombreRequisito = nombreRequisito;
    }

    public Boolean getCumple() {
        return cumple;
    }

    public void setCumple(Boolean cumple) {
        this.cumple = cumple;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
