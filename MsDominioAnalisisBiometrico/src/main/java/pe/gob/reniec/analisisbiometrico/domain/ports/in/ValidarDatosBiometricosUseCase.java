package pe.gob.reniec.analisisbiometrico.domain.ports.in;

import pe.gob.reniec.analisisbiometrico.domain.model.Ciudadano;
import pe.gob.reniec.analisisbiometrico.domain.model.ResultadoAnalisis;

import java.util.List;

/**
 * Puerto de entrada: ValidarDatosBiometricosUseCase
 * Define el contrato para validar datos biométricos de ciudadanos
 */
public interface ValidarDatosBiometricosUseCase {

    /**
     * Valida los datos biométricos de uno o varios ciudadanos
     * @param ciudadanos Lista de ciudadanos con sus datos biométricos
     * @return Lista de resultados de análisis para cada ciudadano
     */
    List<ResultadoAnalisis> validar(List<Ciudadano> ciudadanos);
}
