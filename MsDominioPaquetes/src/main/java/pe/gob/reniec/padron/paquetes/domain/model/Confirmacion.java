package pe.gob.reniec.padron.paquetes.domain.model;

import java.time.LocalDateTime;

public class Confirmacion {
    private Boolean confirmado;
    private LocalDateTime fechaConfirmacion;
    private String usuarioConfirmacion;
    private String comentarioConfirmacion;

    public Confirmacion() {
    }

    public Confirmacion(Boolean confirmado, LocalDateTime fechaConfirmacion, 
                       String usuarioConfirmacion, String comentarioConfirmacion) {
        this.confirmado = confirmado;
        this.fechaConfirmacion = fechaConfirmacion;
        this.usuarioConfirmacion = usuarioConfirmacion;
        this.comentarioConfirmacion = comentarioConfirmacion;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public String getUsuarioConfirmacion() {
        return usuarioConfirmacion;
    }

    public void setUsuarioConfirmacion(String usuarioConfirmacion) {
        this.usuarioConfirmacion = usuarioConfirmacion;
    }

    public String getComentarioConfirmacion() {
        return comentarioConfirmacion;
    }

    public void setComentarioConfirmacion(String comentarioConfirmacion) {
        this.comentarioConfirmacion = comentarioConfirmacion;
    }
}
