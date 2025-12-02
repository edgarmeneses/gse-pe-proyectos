package pe.gob.reniec.padron.paquetes.domain.model;

import java.time.LocalDateTime;

public class Trazabilidad {
    private String accion;
    private LocalDateTime fechaAccion;
    private String usuarioAccion;
    private String ipOrigen;
    private String detalleAccion;

    public Trazabilidad() {
    }

    public Trazabilidad(String accion, LocalDateTime fechaAccion, String usuarioAccion, String ipOrigen, String detalleAccion) {
        this.accion = accion;
        this.fechaAccion = fechaAccion;
        this.usuarioAccion = usuarioAccion;
        this.ipOrigen = ipOrigen;
        this.detalleAccion = detalleAccion;
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
