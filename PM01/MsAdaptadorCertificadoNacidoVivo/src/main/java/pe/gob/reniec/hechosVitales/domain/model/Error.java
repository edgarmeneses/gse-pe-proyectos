package pe.gob.reniec.hechosVitales.domain.model;

import java.util.List;

/**
 * Value Object: Error
 * 
 * Representa la información de error en las respuestas del servicio.
 */
public class Error {
    
    private String tipo;
    private String titulo;
    private Integer estado;
    private List<ErrorDetalle> errores;
    
    public Error() {
    }
    
    public Error(String tipo, String titulo, Integer estado, List<ErrorDetalle> errores) {
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
    
    public List<ErrorDetalle> getErrores() {
        return errores;
    }
    
    public void setErrores(List<ErrorDetalle> errores) {
        this.errores = errores;
    }
}
