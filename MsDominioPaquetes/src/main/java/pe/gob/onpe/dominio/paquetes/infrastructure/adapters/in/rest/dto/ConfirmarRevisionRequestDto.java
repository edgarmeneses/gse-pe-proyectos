package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class ConfirmarRevisionRequestDto {
    private String tipoPadron;
    private String comentarioConfirmacion;
    private Boolean confirmarRevisionCompleta;

    public ConfirmarRevisionRequestDto() {
    }

    public String getTipoPadron() {
        return tipoPadron;
    }

    public void setTipoPadron(String tipoPadron) {
        this.tipoPadron = tipoPadron;
    }

    public String getComentarioConfirmacion() {
        return comentarioConfirmacion;
    }

    public void setComentarioConfirmacion(String comentarioConfirmacion) {
        this.comentarioConfirmacion = comentarioConfirmacion;
    }

    public Boolean getConfirmarRevisionCompleta() {
        return confirmarRevisionCompleta;
    }

    public void setConfirmarRevisionCompleta(Boolean confirmarRevisionCompleta) {
        this.confirmarRevisionCompleta = confirmarRevisionCompleta;
    }
}
