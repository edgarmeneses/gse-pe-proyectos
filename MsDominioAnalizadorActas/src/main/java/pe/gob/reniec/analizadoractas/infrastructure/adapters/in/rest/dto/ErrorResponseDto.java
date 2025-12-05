package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Respuesta de error estandarizada
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

    /**
     * DTO interno: Detalle del error
     */
    public static class ErrorDto {
        private String tipo;
        private String titulo;
        private Integer estado;
        private List<DetalleErrorDto> errores;

        public ErrorDto() {
        }

        public ErrorDto(String tipo, String titulo, Integer estado, List<DetalleErrorDto> errores) {
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

        public List<DetalleErrorDto> getErrores() {
            return errores;
        }

        public void setErrores(List<DetalleErrorDto> errores) {
            this.errores = errores;
        }
    }

    /**
     * DTO interno: Detalle específico de error
     */
    public static class DetalleErrorDto {
        private String detalleError;

        public DetalleErrorDto() {
        }

        public DetalleErrorDto(String detalleError) {
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
