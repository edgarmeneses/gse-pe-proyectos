package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

/**
 * DTO de petición - Actualizar configuración
 * Endpoint: PUT /api/v1/configuracion/MsDatosConfiguracion/{clave}
 */
public class ActualizarConfiguracionRequestDto {

    private Object valor;
    private String motivoCambio;
    private Boolean aplicarInmediatamente;
    private Boolean notificarServicios;
    private Boolean requiereAprobacion;

    public ActualizarConfiguracionRequestDto() {
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public Boolean getAplicarInmediatamente() {
        return aplicarInmediatamente;
    }

    public void setAplicarInmediatamente(Boolean aplicarInmediatamente) {
        this.aplicarInmediatamente = aplicarInmediatamente;
    }

    public Boolean getNotificarServicios() {
        return notificarServicios;
    }

    public void setNotificarServicios(Boolean notificarServicios) {
        this.notificarServicios = notificarServicios;
    }

    public Boolean getRequiereAprobacion() {
        return requiereAprobacion;
    }

    public void setRequiereAprobacion(Boolean requiereAprobacion) {
        this.requiereAprobacion = requiereAprobacion;
    }
}
