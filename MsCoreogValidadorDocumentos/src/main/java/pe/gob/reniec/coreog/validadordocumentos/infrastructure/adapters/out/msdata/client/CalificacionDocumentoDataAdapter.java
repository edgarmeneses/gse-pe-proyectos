package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudCalificacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.CalificacionDocumentoDataPort;

/**
 * Adaptador para comunicación con MsDataValidadorDocumentos para operaciones de calificación
 * Este adaptador implementa el puerto de salida sin definir protocolo de comunicación
 * (no se especifica si es HTTP, SOAP, colas, etc.)
 */
public class CalificacionDocumentoDataAdapter implements CalificacionDocumentoDataPort {
    
    /**
     * Constructor del adaptador
     * En una implementación real, aquí se inyectarían las dependencias necesarias
     * para comunicarse con MsData (cliente HTTP, productor de mensajes, etc.)
     */
    public CalificacionDocumentoDataAdapter() {
        // Sin dependencias de tecnología específica
    }
    
    @Override
    public EvaluacionDocumento procesarCalificacion(SolicitudCalificacion solicitudCalificacion) {
        // Implementación stub - en producción, aquí se realizaría la comunicación con MsData
        // El protocolo de comunicación (HTTP/SOAP/colas) se definiría en tiempo de implementación
        throw new UnsupportedOperationException(
            "Método no implementado. Requiere configuración del protocolo de comunicación con MsDataValidadorDocumentos"
        );
    }
    
    @Override
    public EvaluacionDocumento consultarEvaluacion(String evaluacionId) {
        // Implementación stub - en producción, aquí se realizaría la comunicación con MsData
        throw new UnsupportedOperationException(
            "Método no implementado. Requiere configuración del protocolo de comunicación con MsDataValidadorDocumentos"
        );
    }
}
