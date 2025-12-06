package pe.gob.reniec.configuracion.domain.ports.in;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import java.util.List;

/**
 * Puerto de entrada - Actualizar configuración
 * Endpoint: PUT /api/v1/configuracion/MsDatosConfiguracion/{clave}
 */
public interface ActualizarConfiguracionUseCase {

    /**
     * Actualiza una configuración existente
     *
     * @param clave Clave de la configuración a actualizar
     * @param valor Nuevo valor para la configuración
     * @param motivoCambio Justificación del cambio realizado
     * @param aplicarInmediatamente Aplicar cambio inmediatamente sin esperar despliegue
     * @param notificarServicios Notificar a servicios consumidores sobre el cambio
     * @param requiereAprobacion Si requiere aprobación
     * @return Lista de configuraciones actualizadas
     */
    List<Configuracion> actualizar(
            String clave,
            Object valor,
            String motivoCambio,
            Boolean aplicarInmediatamente,
            Boolean notificarServicios,
            Boolean requiereAprobacion
    );
}
