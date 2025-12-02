package pe.gob.reniec.msdatosregistradores.domain.model;

import java.time.LocalDateTime;

public class Sello {
    private Boolean tieneRegistrado;
    private String hashSello;
    private LocalDateTime fechaUltimaActualizacion;

    public Sello() {
    }

    public Sello(Boolean tieneRegistrado, String hashSello, LocalDateTime fechaUltimaActualizacion) {
        this.tieneRegistrado = tieneRegistrado;
        this.hashSello = hashSello;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Boolean getTieneRegistrado() {
        return tieneRegistrado;
    }

    public void setTieneRegistrado(Boolean tieneRegistrado) {
        this.tieneRegistrado = tieneRegistrado;
    }

    public String getHashSello() {
        return hashSello;
    }

    public void setHashSello(String hashSello) {
        this.hashSello = hashSello;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
}
