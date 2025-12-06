package pe.gob.reniec.configuracion.application.service;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import pe.gob.reniec.configuracion.domain.model.ResultadoValidacion;
import pe.gob.reniec.configuracion.domain.ports.in.ValidarConfiguracionUseCase;
import pe.gob.reniec.configuracion.domain.ports.out.ConfiguracionRepositoryPort;

/**
 * Servicio de aplicación - Validar configuración
 */
public class ValidarConfiguracionService implements ValidarConfiguracionUseCase {

    private final ConfiguracionRepositoryPort configuracionRepositoryPort;

    public ValidarConfiguracionService(ConfiguracionRepositoryPort configuracionRepositoryPort) {
        this.configuracionRepositoryPort = configuracionRepositoryPort;
    }

    @Override
    public ResultadoValidacion validar(
            String clave,
            Object valor,
            Configuracion.Contexto contexto,
            Boolean validarDependencias
    ) {
        return configuracionRepositoryPort.validar(
                clave,
                valor,
                contexto,
                validarDependencias
        );
    }
}
