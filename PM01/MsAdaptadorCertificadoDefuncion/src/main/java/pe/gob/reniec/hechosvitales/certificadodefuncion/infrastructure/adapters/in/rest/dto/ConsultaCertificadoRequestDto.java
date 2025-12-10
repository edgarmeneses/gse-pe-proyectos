package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO de Request para consulta de certificados de defunción
 * Usado tanto para datos básicos como para detalle completo
 */
public class ConsultaCertificadoRequestDto {

    private String coEntidadConsulta;
    private String coTipoDocIdentidad;
    private String deDocIdentidad;

    public ConsultaCertificadoRequestDto() {
    }

    public ConsultaCertificadoRequestDto(String coEntidadConsulta, String coTipoDocIdentidad, String deDocIdentidad) {
        this.coEntidadConsulta = coEntidadConsulta;
        this.coTipoDocIdentidad = coTipoDocIdentidad;
        this.deDocIdentidad = deDocIdentidad;
    }

    public String getCoEntidadConsulta() {
        return coEntidadConsulta;
    }

    public void setCoEntidadConsulta(String coEntidadConsulta) {
        this.coEntidadConsulta = coEntidadConsulta;
    }

    public String getCoTipoDocIdentidad() {
        return coTipoDocIdentidad;
    }

    public void setCoTipoDocIdentidad(String coTipoDocIdentidad) {
        this.coTipoDocIdentidad = coTipoDocIdentidad;
    }

    public String getDeDocIdentidad() {
        return deDocIdentidad;
    }

    public void setDeDocIdentidad(String deDocIdentidad) {
        this.deDocIdentidad = deDocIdentidad;
    }
}
