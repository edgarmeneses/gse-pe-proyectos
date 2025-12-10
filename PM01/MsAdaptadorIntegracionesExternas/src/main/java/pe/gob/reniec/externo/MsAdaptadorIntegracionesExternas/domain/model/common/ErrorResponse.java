package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.common;

import java.util.List;

public class ErrorResponse {
    private String tipo;
    private String titulo;
    private Integer estado;
    private List<ErrorDetalle> errores;

    public ErrorResponse() {}

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }

    public List<ErrorDetalle> getErrores() { return errores; }
    public void setErrores(List<ErrorDetalle> errores) { this.errores = errores; }
}
