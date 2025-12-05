package pe.gob.reniec.analisisbiometrico.application.service;

import pe.gob.reniec.analisisbiometrico.domain.model.Ciudadano;
import pe.gob.reniec.analisisbiometrico.domain.model.ResultadoAnalisis;
import pe.gob.reniec.analisisbiometrico.domain.ports.in.ValidarDatosBiometricosUseCase;
import pe.gob.reniec.analisisbiometrico.domain.ports.out.AnalisisBiometricoDataPort;

import java.util.List;

/**
 * Servicio de aplicación: ValidarDatosBiometricosService
 * Implementa la lógica de negocio para validar datos biométricos
 */
public class ValidarDatosBiometricosService implements ValidarDatosBiometricosUseCase {

    private final AnalisisBiometricoDataPort analisisBiometricoDataPort;

    public ValidarDatosBiometricosService(AnalisisBiometricoDataPort analisisBiometricoDataPort) {
        this.analisisBiometricoDataPort = analisisBiometricoDataPort;
    }

    @Override
    public List<ResultadoAnalisis> validar(List<Ciudadano> ciudadanos) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
