package pe.gob.reniec.configuracion.application.service;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import pe.gob.reniec.configuracion.domain.ports.in.ConsultarConfiguracionesPorCategoriaUseCase;
import pe.gob.reniec.configuracion.domain.ports.out.ConfiguracionRepositoryPort;

import java.util.List;

/**
 * Servicio de aplicación - Consultar configuraciones por categoría
 */
public class ConsultarConfiguracionesPorCategoriaService implements ConsultarConfiguracionesPorCategoriaUseCase {

    private final ConfiguracionRepositoryPort configuracionRepositoryPort;

    public ConsultarConfiguracionesPorCategoriaService(ConfiguracionRepositoryPort configuracionRepositoryPort) {
        this.configuracionRepositoryPort = configuracionRepositoryPort;
    }

    @Override
    public List<Configuracion> consultarPorCategoria(
            String categoria,
            String subcategoria,
            Boolean soloActivas,
            Boolean incluirHistorial,
            Integer page,
            Integer size
    ) {
        return configuracionRepositoryPort.buscarPorCategoria(
                categoria,
                subcategoria,
                soloActivas,
                incluirHistorial,
                page,
                size
        );
    }
}
