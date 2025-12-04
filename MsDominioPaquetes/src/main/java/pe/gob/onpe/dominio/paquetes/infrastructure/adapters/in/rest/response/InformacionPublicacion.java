package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

import java.time.LocalDateTime;

/**
 * Información administrativa de publicación de un paquete electoral.
 * Esta clase pertenece a la capa de aplicación.
 * Es metadata opcional que se registra al aprobar un paquete, no es parte del dominio puro.
 */
public class InformacionPublicacion {
    private LocalDateTime fechaPublicacion;
    private String lugarPublicacion;
    private String observaciones;

    public InformacionPublicacion() {
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getLugarPublicacion() {
        return lugarPublicacion;
    }

    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
