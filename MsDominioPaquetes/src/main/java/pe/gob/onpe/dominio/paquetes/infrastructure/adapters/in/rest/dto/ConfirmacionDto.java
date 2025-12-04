package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class ConfirmacionDto {
    private Boolean confirmado;
    private String fechaConfirmacion;
    private String usuarioConfirmacion;
    private String comentarioConfirmacion;

    public ConfirmacionDto() {
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(String fechaConfirmacion) {
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
