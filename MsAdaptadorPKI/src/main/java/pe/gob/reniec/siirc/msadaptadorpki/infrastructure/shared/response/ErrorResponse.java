package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Estructura de respuesta de error según RFC 7807 (Problem Details).
 * Esta es una estructura técnica de respuesta HTTP.
 * NO es un concepto del dominio de negocio.
 */
public class ErrorResponse {
    private String tipo;
    private String titulo;
    private Integer estado;
    private String detalle;
    private String instancia;
    private List<DetalleError> errores;
    private LocalDateTime timestamp;
    private String correlationId;

    public ErrorResponse() {
    }

    public ErrorResponse(String tipo, String titulo, Integer estado, String detalle, String instancia,
                        List<DetalleError> errores, LocalDateTime timestamp, String correlationId) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.estado = estado;
        this.detalle = detalle;
        this.instancia = instancia;
        this.errores = errores;
        this.timestamp = timestamp;
        this.correlationId = correlationId;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public List<DetalleError> getErrores() {
        return errores;
    }

    public void setErrores(List<DetalleError> errores) {
        this.errores = errores;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
