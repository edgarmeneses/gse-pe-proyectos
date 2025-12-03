package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudVerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.VerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.VerificacionFirmaDataPort;

/**
 * Adaptador para comunicación con MsDataValidadorDocumentos para operaciones de verificación de firmas
 * Este adaptador implementa el puerto de salida sin definir protocolo de comunicación
 * (no se especifica si es HTTP, SOAP, colas, etc.)
 */
public class VerificacionFirmaDataAdapter implements VerificacionFirmaDataPort {
    
    /**
     * Constructor del adaptador
     * En una implementación real, aquí se inyectarían las dependencias necesarias
     * para comunicarse con MsData (cliente HTTP, productor de mensajes, etc.)
     */
    public VerificacionFirmaDataAdapter() {
        // Sin dependencias de tecnología específica
    }
    
    @Override
    public VerificacionFirma procesarVerificacion(SolicitudVerificacionFirma solicitudVerificacion) {
        // Implementación stub - en producción, aquí se realizaría la comunicación con MsData
        // El protocolo de comunicación (HTTP/SOAP/colas) se definiría en tiempo de implementación
        throw new UnsupportedOperationException(
            "Método no implementado. Requiere configuración del protocolo de comunicación con MsDataValidadorDocumentos"
        );
    }
    
    @Override
    public VerificacionFirma consultarVerificacion(String verificacionId) {
        // Implementación stub - en producción, aquí se realizaría la comunicación con MsData
        throw new UnsupportedOperationException(
            "Método no implementado. Requiere configuración del protocolo de comunicación con MsDataValidadorDocumentos"
        );
    }
}
