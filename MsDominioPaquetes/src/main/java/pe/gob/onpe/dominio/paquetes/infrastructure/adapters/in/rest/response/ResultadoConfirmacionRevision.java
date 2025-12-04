package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

import pe.gob.onpe.dominio.paquetes.domain.model.Confirmacion;

/**
 * Objeto de resultado para la confirmación de revisión de paquetes electorales.
 * Esta clase pertenece a la capa de aplicación, no al dominio.
 * Representa el resultado de la operación de confirmación con información de seguimiento.
 */
public class ResultadoConfirmacionRevision {
    private String idPadron;
    private String tipoPadron;
    private String codigoCronogramaElectoral;
    private String estadoRevisionAnterior;
    private String estadoRevisionActual;
    private Confirmacion confirmacion;
    private ResumenPaquetes resumenPaquetes;
    private InformacionSiguientePaso siguientePaso;
    private InformacionTrazabilidad trazabilidad;

    public ResultadoConfirmacionRevision() {
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

    public InformacionSiguientePaso getSiguientePaso() {
        return siguientePaso;
    }

    public void setSiguientePaso(InformacionSiguientePaso siguientePaso) {
        this.siguientePaso = siguientePaso;
    }

    public InformacionTrazabilidad getTrazabilidad() {
        return trazabilidad;
    }

    public void setTrazabilidad(InformacionTrazabilidad trazabilidad) {
        this.trazabilidad = trazabilidad;
    }
}
