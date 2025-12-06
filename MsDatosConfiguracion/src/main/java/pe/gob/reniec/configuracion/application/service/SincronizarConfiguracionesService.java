package pe.gob.reniec.configuracion.application.service;

import pe.gob.reniec.configuracion.domain.model.ConfiguracionSincronizacion;
import pe.gob.reniec.configuracion.domain.model.ResultadoSincronizacion;
import pe.gob.reniec.configuracion.domain.ports.in.SincronizarConfiguracionesUseCase;
import pe.gob.reniec.configuracion.domain.ports.out.ConfiguracionRepositoryPort;

/**
 * Servicio de aplicación - Sincronizar configuraciones
 */
public class SincronizarConfiguracionesService implements SincronizarConfiguracionesUseCase {

    private final ConfiguracionRepositoryPort configuracionRepositoryPort;

    public SincronizarConfiguracionesService(ConfiguracionRepositoryPort configuracionRepositoryPort) {
        this.configuracionRepositoryPort = configuracionRepositoryPort;
    }

    @Override
    public ResultadoSincronizacion sincronizar(ConfiguracionSincronizacion sincronizacion) {
        return configuracionRepositoryPort.sincronizar(sincronizacion);
    }
}
