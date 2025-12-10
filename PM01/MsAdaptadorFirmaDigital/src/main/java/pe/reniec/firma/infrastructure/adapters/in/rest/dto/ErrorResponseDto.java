package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ErrorResponseDto {
    private ErrorDetail error;

    public ErrorResponseDto() {}

    public ErrorDetail getError() {
        return error;
    }

    public void setError(ErrorDetail error) {
        this.error = error;
    }

    public static class ErrorDetail {
        private String tipo;
        private String titulo;
        private Integer estado;
        private List<DetalleError> errores;

        public ErrorDetail() {}

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
