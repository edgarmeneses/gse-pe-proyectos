package pe.gob.reniec.analizadoractas.domain.model;

/**
 * Value Object: Representa una alerta o inconsistencia detectada por el análisis de IA
 */
public class AlertaDetectada {

    private String codigoAlerta;
    private String tipoAlerta;
    private String descripcion;
    private String severidad;
    private String campoAfectado;

    public AlertaDetectada() {
    }

    public AlertaDetectada(String codigoAlerta, String tipoAlerta, String descripcion,
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
