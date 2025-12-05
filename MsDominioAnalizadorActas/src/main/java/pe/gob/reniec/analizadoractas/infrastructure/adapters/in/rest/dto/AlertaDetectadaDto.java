package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Alerta detectada por el análisis de IA
 */
public class AlertaDetectadaDto {

    private String codigoAlerta;
    private String tipoAlerta;
    private String descripcion;
    private String severidad;
    private String campoAfectado;

    public AlertaDetectadaDto() {
    }

    public AlertaDetectadaDto(String codigoAlerta, String tipoAlerta, String descripcion,
                              String severidad, String campoAfectado) {
        this.codigoAlerta = codigoAlerta;
        this.tipoAlerta = tipoAlerta;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.campoAfectado = campoAfectado;
    }

    public String getCodigoAlerta() {
        return codigoAlerta;
    }

    public void setCodigoAlerta(String codigoAlerta) {
        this.codigoAlerta = codigoAlerta;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getCampoAfectado() {
        return campoAfectado;
    }

    public void setCampoAfectado(String campoAfectado) {
        this.campoAfectado = campoAfectado;
    }
}
