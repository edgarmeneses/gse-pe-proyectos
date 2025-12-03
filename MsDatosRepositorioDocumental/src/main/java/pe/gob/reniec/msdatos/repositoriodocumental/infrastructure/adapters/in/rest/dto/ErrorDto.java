package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Respuesta de error estándar
 */
public class ErrorDto {
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
