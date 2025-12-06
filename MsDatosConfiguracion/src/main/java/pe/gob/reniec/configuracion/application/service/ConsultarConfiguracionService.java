package pe.gob.reniec.configuracion.application.service;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import pe.gob.reniec.configuracion.domain.ports.in.ConsultarConfiguracionUseCase;
import pe.gob.reniec.configuracion.domain.ports.out.ConfiguracionRepositoryPort;

/**
 * Servicio de aplicación - Consultar configuración por clave
 */
public class ConsultarConfiguracionService implements ConsultarConfiguracionUseCase {

    private final ConfiguracionRepositoryPort configuracionRepositoryPort;

    public ConsultarConfiguracionService(ConfiguracionRepositoryPort configuracionRepositoryPort) {
        this.configuracionRepositoryPort = configuracionRepositoryPort;
    }

    @Override
    public Configuracion consultarPorClave(
            String clave,
            String contexto,
            String ambiente,
            Integer version,
            Boolean incluirMetadata
    ) {
        return configuracionRepositoryPort.buscarPorClave(
                clave,
                contexto,
                ambiente,
                version,
                incluirMetadata
        );
    }
}
