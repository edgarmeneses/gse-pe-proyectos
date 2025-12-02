package pe.gob.reniec.padron.paquetes.domain.model;

public class ConfirmacionRevisionResult {
    private String idPadron;
    private String tipoPadron;
    private String codigoCronogramaElectoral;
    private String estadoRevisionAnterior;
    private String estadoRevisionActual;
    private Confirmacion confirmacion;
    private ResumenPaquetes resumenPaquetes;
    private SiguientePaso siguientePaso;
    private Trazabilidad trazabilidad;

    public ConfirmacionRevisionResult() {
    }

    public ConfirmacionRevisionResult(String idPadron, String tipoPadron, String codigoCronogramaElectoral,
                                     String estadoRevisionAnterior, String estadoRevisionActual,
                                     Confirmacion confirmacion, ResumenPaquetes resumenPaquetes,
                                     SiguientePaso siguientePaso, Trazabilidad trazabilidad) {
        this.idPadron = idPadron;
        this.tipoPadron = tipoPadron;
        this.codigoCronogramaElectoral = codigoCronogramaElectoral;
        this.estadoRevisionAnterior = estadoRevisionAnterior;
        this.estadoRevisionActual = estadoRevisionActual;
        this.confirmacion = confirmacion;
        this.resumenPaquetes = resumenPaquetes;
        this.siguientePaso = siguientePaso;
        this.trazabilidad = trazabilidad;
    }

    public String getIdPadron() {
        return idPadron;
    }

    public void setIdPadron(String idPadron) {
        this.idPadron = idPadron;
    }

    public String getTipoPadron() {
        return tipoPadron;
    }

    public void setTipoPadron(String tipoPadron) {
        this.tipoPadron = tipoPadron;
    }

    public String getCodigoCronogramaElectoral() {
        return codigoCronogramaElectoral;
    }

    public void setCodigoCronogramaElectoral(String codigoCronogramaElectoral) {
        this.codigoCronogramaElectoral = codigoCronogramaElectoral;
    }

    public String getEstadoRevisionAnterior() {
        return estadoRevisionAnterior;
    }

    public void setEstadoRevisionAnterior(String estadoRevisionAnterior) {
        this.estadoRevisionAnterior = estadoRevisionAnterior;
    }

    public String getEstadoRevisionActual() {
        return estadoRevisionActual;
    }

    public void setEstadoRevisionActual(String estadoRevisionActual) {
        this.estadoRevisionActual = estadoRevisionActual;
    }

    public Confirmacion getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Confirmacion confirmacion) {
        this.confirmacion = confirmacion;
    }

    public ResumenPaquetes getResumenPaquetes() {
        return resumenPaquetes;
    }

    public void setResumenPaquetes(ResumenPaquetes resumenPaquetes) {
        this.resumenPaquetes = resumenPaquetes;
    }

    public SiguientePaso getSiguientePaso() {
        return siguientePaso;
    }

    public void setSiguientePaso(SiguientePaso siguientePaso) {
        this.siguientePaso = siguientePaso;
    }

    public Trazabilidad getTrazabilidad() {
        return trazabilidad;
    }

    public void setTrazabilidad(Trazabilidad trazabilidad) {
        this.trazabilidad = trazabilidad;
    }
}
