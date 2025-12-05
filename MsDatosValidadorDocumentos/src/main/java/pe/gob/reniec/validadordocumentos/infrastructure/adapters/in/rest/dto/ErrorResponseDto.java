package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de respuesta de error estandarizado.
 */
public class ErrorResponseDto {

    private String tipo;
    private String titulo;
    private Integer estado;
    private List<ErrorDetailDto> errores;

    public ErrorResponseDto() {
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
