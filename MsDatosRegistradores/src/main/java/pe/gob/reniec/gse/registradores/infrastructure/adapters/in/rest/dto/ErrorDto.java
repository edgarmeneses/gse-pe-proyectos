package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Error
 */
public class ErrorDto {
    private String tipo;
    private String titulo;
    private Long estado;
    private List<ErrorDetalleDto> errores;

    public ErrorDto() {
    }

    public ErrorDto(String tipo, String titulo, Long estado, List<ErrorDetalleDto> errores) {
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

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public List<ErrorDetalleDto> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorDetalleDto> errores) {
        this.errores = errores;
    }
}
