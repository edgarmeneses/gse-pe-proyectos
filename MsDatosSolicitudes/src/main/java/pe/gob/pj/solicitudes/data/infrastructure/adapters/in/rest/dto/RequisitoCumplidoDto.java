package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class RequisitoCumplidoDto {
    private final String requisitoId;
    private final String nombreRequisito;
    private final Boolean cumple;
    private final String observacion;

    public RequisitoCumplidoDto(String requisitoId, String nombreRequisito, Boolean cumple, String observacion) {
        this.requisitoId = requisitoId;
        this.nombreRequisito = nombreRequisito;
        this.cumple = cumple;
        this.observacion = observacion;
    }

    public String requisitoId() { return requisitoId; }
    public String nombreRequisito() { return nombreRequisito; }
    public Boolean cumple() { return cumple; }
    public String observacion() { return observacion; }
}
