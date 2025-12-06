package pe.gob.reniec.configuracion.application.service;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import pe.gob.reniec.configuracion.domain.ports.in.ActualizarConfiguracionUseCase;
import pe.gob.reniec.configuracion.domain.ports.out.ConfiguracionRepositoryPort;

import java.util.List;

/**
 * Servicio de aplicación - Actualizar configuración
 */
public class ActualizarConfiguracionService implements ActualizarConfiguracionUseCase {

    private final ConfiguracionRepositoryPort configuracionRepositoryPort;

    public ActualizarConfiguracionService(ConfiguracionRepositoryPort configuracionRepositoryPort) {
        this.configuracionRepositoryPort = configuracionRepositoryPort;
    }

    @Override
    public List<Configuracion> actualizar(
            String clave,
            Object valor,
            String motivoCambio,
            Boolean aplicarInmediatamente,
            Boolean notificarServicios,
            Boolean requiereAprobacion
    ) {
        return configuracionRepositoryPort.actualizar(
                clave,
                valor,
                motivoCambio,
                aplicarInmediatamente,
                notificarServicios,
                requiereAprobacion
        );
    }
}
