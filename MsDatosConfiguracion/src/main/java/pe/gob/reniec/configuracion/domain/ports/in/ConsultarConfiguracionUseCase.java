package pe.gob.reniec.configuracion.domain.ports.in;

import pe.gob.reniec.configuracion.domain.model.Configuracion;

/**
 * Puerto de entrada - Consultar configuración por clave
 * Endpoint: GET /api/v1/configuracion/MsDatosConfiguracion
 */
public interface ConsultarConfiguracionUseCase {

    /**
     * Consulta una configuración específica por su clave
     *
     * @param clave Clave de la configuración
     * @param contexto Filtro adicional de contexto
     * @param ambiente Nombre del ambiente
     * @param version Versión específica de la configuración
     * @param incluirMetadata Indica si se debe incluir información de metadata
     * @return Configuración encontrada
     */
    Configuracion consultarPorClave(
            String clave,
            String contexto,
            String ambiente,
            Integer version,
            Boolean incluirMetadata
    );
}
