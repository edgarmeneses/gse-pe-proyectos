package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Error Response: ErrorResponseDto
 * Representa la estructura de respuesta de error estándar.
 */
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
        private List<ErrorDetalleDto> errores;

        public ErrorDto() {
        }

        public ErrorDto(String tipo, String titulo, Integer estado, List<ErrorDetalleDto> errores) {
            this.tipo = tipo;
            this.titulo = titulo;
            this.estado = estado;
            this.errores = errores;
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

        public List<ErrorDetalleDto> getErrores() {
            return errores;
        }

        public void setErrores(List<ErrorDetalleDto> errores) {
            this.errores = errores;
        }
    }

    public static class ErrorDetalleDto {
        private String detalleError;

        public ErrorDetalleDto() {
        }

        public ErrorDetalleDto(String detalleError) {
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
