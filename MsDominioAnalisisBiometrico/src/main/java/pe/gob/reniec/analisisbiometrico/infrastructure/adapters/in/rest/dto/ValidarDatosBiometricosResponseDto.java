package pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de response para validación de datos biométricos
 */
public class ValidarDatosBiometricosResponseDto {

    private List<ResultadoAnalisisDto> resultadoAnalisis;

    public ValidarDatosBiometricosResponseDto() {
    }

    public ValidarDatosBiometricosResponseDto(List<ResultadoAnalisisDto> resultadoAnalisis) {
        this.resultadoAnalisis = resultadoAnalisis;
    }

    public List<ResultadoAnalisisDto> getResultadoAnalisis() {
        return resultadoAnalisis;
    }

    public void setResultadoAnalisis(List<ResultadoAnalisisDto> resultadoAnalisis) {
        this.resultadoAnalisis = resultadoAnalisis;
    }
}
