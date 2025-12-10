package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.response;

import java.util.List;

public class ErrorResponse {
    private String tipo;
    private String titulo;
    private Integer estado;
    private List<DetalleError> errores;

    public ErrorResponse() {}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<DetalleError> getErrores() {
        return errores;
    }

    public void setErrores(List<DetalleError> errores) {
        this.errores = errores;
    }

    public static class DetalleError {
        private String detalleError;

        public DetalleError() {}

        public String getDetalleError() {
            return detalleError;
        }

        public void setDetalleError(String detalleError) {
            this.detalleError = detalleError;
        }
    }
}
