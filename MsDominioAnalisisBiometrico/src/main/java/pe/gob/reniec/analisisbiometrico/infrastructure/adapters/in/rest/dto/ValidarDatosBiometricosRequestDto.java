package pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de request para validación de datos biométricos
 */
public class ValidarDatosBiometricosRequestDto {

    private List<CiudadanoRequestDto> ciudadanos;

    public ValidarDatosBiometricosRequestDto() {
    }

    public ValidarDatosBiometricosRequestDto(List<CiudadanoRequestDto> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public List<CiudadanoRequestDto> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(List<CiudadanoRequestDto> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }
}
