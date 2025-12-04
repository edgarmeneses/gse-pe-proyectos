package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

import java.time.LocalDateTime;

/**
 * Información de trazabilidad para auditoría.
 * Esta clase pertenece a la capa de aplicación.
 * Contiene información técnica de auditoría que no es parte del modelo de negocio.
 */
public class InformacionTrazabilidad {
    private String accion;
    private LocalDateTime fechaAccion;
    private String usuarioAccion;
    private String ipOrigen;
    private String detalleAccion;

    public InformacionTrazabilidad() {
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDateTime getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(LocalDateTime fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public String getUsuarioAccion() {
        return usuarioAccion;
    }

    public void setUsuarioAccion(String usuarioAccion) {
        this.usuarioAccion = usuarioAccion;
    }

    public String getIpOrigen() {
        return ipOrigen;
    }

    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }

    public String getDetalleAccion() {
        return detalleAccion;
    }

    public void setDetalleAccion(String detalleAccion) {
        this.detalleAccion = detalleAccion;
    }
}
