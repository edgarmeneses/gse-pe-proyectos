package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Asignación Actual
 */
public class AsignacionActualDto {
    private String codigoLocal;
    private String descripcionLocal;
    private String codigoEstadoRegistrador;
    private String descripcionEstado;
    private String fechaAsignacion;

    public AsignacionActualDto() {
    }

    public AsignacionActualDto(String codigoLocal, String descripcionLocal, String codigoEstadoRegistrador, 
                              String descripcionEstado, String fechaAsignacion) {
        this.codigoLocal = codigoLocal;
        this.descripcionLocal = descripcionLocal;
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
        this.descripcionEstado = descripcionEstado;
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getDescripcionLocal() {
        return descripcionLocal;
    }

    public void setDescripcionLocal(String descripcionLocal) {
        this.descripcionLocal = descripcionLocal;
    }

    public String getCodigoEstadoRegistrador() {
        return codigoEstadoRegistrador;
    }

    public void setCodigoEstadoRegistrador(String codigoEstadoRegistrador) {
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
