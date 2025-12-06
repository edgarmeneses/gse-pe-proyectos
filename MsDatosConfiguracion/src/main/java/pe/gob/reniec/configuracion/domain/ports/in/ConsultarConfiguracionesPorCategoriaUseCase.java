package pe.gob.reniec.configuracion.domain.ports.in;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import java.util.List;

/**
 * Puerto de entrada - Consultar configuraciones por categoría
 * Endpoint: GET /api/v1/configuracion/MsDatosConfiguracion/categoria
 */
public interface ConsultarConfiguracionesPorCategoriaUseCase {

    /**
     * Consulta configuraciones filtradas por categoría
     *
     * @param categoria Categoría de configuración
     * @param subcategoria Filtro por subcategoría específica
     * @param soloActivas Retornar solo configuraciones con estado ACTIVA
     * @param incluirHistorial Incluir historial completo de cambios
     * @param page Número de página para paginación
     * @param size Cantidad de elementos por página
     * @return Lista de configuraciones de la categoría
     */
    List<Configuracion> consultarPorCategoria(
            String categoria,
            String subcategoria,
            Boolean soloActivas,
            Boolean incluirHistorial,
            Integer page,
            Integer size
    );
}
