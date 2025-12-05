package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ErrorResponseDto {

    private ErrorDto error;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(ErrorDto error) {
        this.error = error;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }

    public static class ErrorDto {
        private String tipo;
        private String titulo;
        private Integer estado;
        private List<ErrorDetailDto> errores;

        public ErrorDto() {
        }

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

        public List<ErrorDetailDto> getErrores() {
            return errores;
        }

        public void setErrores(List<ErrorDetailDto> errores) {
            this.errores = errores;
        }
    }

    public static class ErrorDetailDto {
        private String detalleError;

        public ErrorDetailDto() {
        }

        public ErrorDetailDto(String detalleError) {
            this.detalleError = detalleError;
        }

        public String getDetalleError() {
            return detalleError;
        }

        public void setDetalleError(String detalleError) {
            this.detalleError = detalleError;
        }
    }
}
