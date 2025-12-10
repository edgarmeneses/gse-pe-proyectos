package pe.gob.reniec.padronelectoral.infrastructure.dto;

import java.util.List;

public class ErrorResponse {
    private String tipo;
    private String titulo;
    private Integer estado;
    private List<ErrorDetail> errores;

    public ErrorResponse() {
    }

    public ErrorResponse(String tipo, String titulo, Integer estado, List<ErrorDetail> errores) {
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

    public List<ErrorDetail> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorDetail> errores) {
        this.errores = errores;
    }
}
