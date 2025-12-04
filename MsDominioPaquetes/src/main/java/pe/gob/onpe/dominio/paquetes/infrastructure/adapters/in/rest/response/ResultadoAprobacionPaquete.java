package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

import pe.gob.onpe.dominio.paquetes.domain.model.Aprobacion;

/**
 * Objeto de resultado para la aprobación de un paquete electoral.
 * Esta clase pertenece a la capa de aplicación, no al dominio.
 * Representa el resultado de la operación de aprobación con información de trazabilidad.
 */
public class ResultadoAprobacionPaquete {
    private String paqueteId;
    private String codigoPaquete;
    private String estadoAnterior;
    private String estadoActual;
    private Aprobacion aprobacion;
    private InformacionPublicacion informacionPublicacion;
    private InformacionTrazabilidad trazabilidad;

    public ResultadoAprobacionPaquete() {
    }

    public String getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(String paqueteId) {
        this.paqueteId = paqueteId;
    }

    public String getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(String codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Aprobacion getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Aprobacion aprobacion) {
        this.aprobacion = aprobacion;
    }

    public InformacionPublicacion getInformacionPublicacion() {
        return informacionPublicacion;
    }

    public void setInformacionPublicacion(InformacionPublicacion informacionPublicacion) {
        this.informacionPublicacion = informacionPublicacion;
    }

    public InformacionTrazabilidad getTrazabilidad() {
        return trazabilidad;
    }

    public void setTrazabilidad(InformacionTrazabilidad trazabilidad) {
        this.trazabilidad = trazabilidad;
    }
}
