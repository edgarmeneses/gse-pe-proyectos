package pe.gob.reniec.configuracion.domain.ports.in;

import pe.gob.reniec.configuracion.domain.model.ConfiguracionSincronizacion;
import pe.gob.reniec.configuracion.domain.model.ResultadoSincronizacion;

/**
 * Puerto de entrada - Sincronizar configuraciones (Modo Offline/Online)
 * Endpoint: POST /api/v1/configuracion/MsDatosConfiguracion/sincronizar
 */
public interface SincronizarConfiguracionesUseCase {

    /**
     * Sincroniza configuraciones entre dispositivo y servidor
     *
     * @param sincronizacion Datos de sincronización del dispositivo
     * @return Resultado de la operación de sincronización
     */
    ResultadoSincronizacion sincronizar(ConfiguracionSincronizacion sincronizacion);
}
