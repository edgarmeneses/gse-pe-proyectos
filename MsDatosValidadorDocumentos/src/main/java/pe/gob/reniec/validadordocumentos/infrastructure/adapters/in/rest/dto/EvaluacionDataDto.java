package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO que representa los datos de la evaluación registrada en la respuesta.
 */
public class EvaluacionDataDto {

    private String evaluacionId;
    private String solicitudId;
    private String tramiteId;
    private String fechaRegistro;
    private String estadoPersistencia;
    private RegistrosCreadosDto registrosCreados;

    public EvaluacionDataDto() {
    }

    public String getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(String evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoPersistencia() {
        return estadoPersistencia;
    }

    public void setEstadoPersistencia(String estadoPersistencia) {
        this.estadoPersistencia = estadoPersistencia;
    }

    public RegistrosCreadosDto getRegistrosCreados() {
        return registrosCreados;
    }

    public void setRegistrosCreados(RegistrosCreadosDto registrosCreados) {
        this.registrosCreados = registrosCreados;
    }
}
