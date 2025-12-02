package pe.gob.reniec.padron.paquetes.domain.model;

public class AprobacionResult {
    private String paqueteId;
    private String codigoPaquete;
    private String estadoAnterior;
    private String estadoActual;
    private Aprobacion aprobacion;
    private InformacionPublicacion informacionPublicacion;
    private Trazabilidad trazabilidad;

    public AprobacionResult() {
    }

    public AprobacionResult(String paqueteId, String codigoPaquete, String estadoAnterior, 
                           String estadoActual, Aprobacion aprobacion, 
                           InformacionPublicacion informacionPublicacion, Trazabilidad trazabilidad) {
        this.paqueteId = paqueteId;
        this.codigoPaquete = codigoPaquete;
        this.estadoAnterior = estadoAnterior;
        this.estadoActual = estadoActual;
        this.aprobacion = aprobacion;
        this.informacionPublicacion = informacionPublicacion;
        this.trazabilidad = trazabilidad;
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

    public Trazabilidad getTrazabilidad() {
        return trazabilidad;
    }

    public void setTrazabilidad(Trazabilidad trazabilidad) {
        this.trazabilidad = trazabilidad;
    }
}
