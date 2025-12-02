package pe.gob.reniec.padron.paquetes.domain.model;

import java.time.LocalDateTime;

public class InformacionPublicacion {
    private LocalDateTime fechaPublicacion;
    private String lugarPublicacion;
    private String observaciones;

    public InformacionPublicacion() {
    }

    public InformacionPublicacion(LocalDateTime fechaPublicacion, String lugarPublicacion, String observaciones) {
        this.fechaPublicacion = fechaPublicacion;
        this.lugarPublicacion = lugarPublicacion;
        this.observaciones = observaciones;
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
