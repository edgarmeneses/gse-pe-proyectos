package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ErrorResponseDto {
    private ErrorDto error;

    public ErrorResponseDto() {}

    public ErrorDto getError() { return error; }
    public void setError(ErrorDto error) { this.error = error; }

    public static class ErrorDto {
        private String tipo;
        private String titulo;
        private Integer estado;
        private List<DetalleErrorDto> errores;

        public ErrorDto() {}

        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }

        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }

        public Integer getEstado() { return estado; }
        public void setEstado(Integer estado) { this.estado = estado; }

        public List<DetalleErrorDto> getErrores() { return errores; }
        public void setErrores(List<DetalleErrorDto> errores) { this.errores = errores; }
    }

    public static class DetalleErrorDto {
        private String detalleError;

        public DetalleErrorDto() {}

        public String getDetalleError() { return detalleError; }
        public void setDetalleError(String detalleError) { this.detalleError = detalleError; }
    }
}
