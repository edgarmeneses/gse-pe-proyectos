package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.protecciondocumentos.domain.model.ConfiguracionProteccion;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.ConfiguracionDataPort;

/**
 * Adaptador cliente para integración con MsDatosConfiguracion.
 * Este adaptador implementa los puertos de salida para obtener configuraciones
 * desde el microservicio de datos externo.
 * 
 * NOTA: Esta implementación no define el protocolo de comunicación (HTTP, SOAP, mensajería, etc.)
 * ya que esto será definido en una capa de implementación tecnológica específica.
 */
public class ConfiguracionDataAdapter implements ConfiguracionDataPort {

    @Override
    public ConfiguracionProteccion obtenerConfiguracionPorDefecto() {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsDatosConfiguracion según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Integración con MsDatosConfiguracion no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación."
        );
    }

    @Override
    public ConfiguracionProteccion validarConfiguracion(ConfiguracionProteccion configuracion) {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsDatosConfiguracion según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Validación de configuración con MsDatosConfiguracion no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación."
        );
    }
}
