package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.protecciondocumentos.domain.model.ProteccionDocumento;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.ProteccionDocumentoDataPort;

/**
 * Adaptador cliente para integración con MsDataProteccionDocumentos.
 * Este adaptador implementa los puertos de salida para gestionar la persistencia
 * de las protecciones de documentos en el microservicio de datos correspondiente.
 * 
 * NOTA: Esta implementación no define el protocolo de comunicación (HTTP, SOAP, mensajería, etc.)
 * ya que esto será definido en una capa de implementación tecnológica específica.
 */
public class ProteccionDocumentoDataAdapter implements ProteccionDocumentoDataPort {

    @Override
    public ProteccionDocumento guardarProteccionDocumento(ProteccionDocumento proteccionDocumento) {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsDataProteccionDocumentos según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Integración con MsDataProteccionDocumentos para guardar no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación."
        );
    }

    @Override
    public ProteccionDocumento obtenerProteccionDocumentoPorId(String proteccionId) {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsDataProteccionDocumentos según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Integración con MsDataProteccionDocumentos para obtener por ID no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación. " +
            "Parámetro recibido: proteccionId=" + proteccionId
        );
    }

    @Override
    public boolean existeProteccionPorSolicitudId(String solicitudId) {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsDataProteccionDocumentos según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Integración con MsDataProteccionDocumentos para verificar existencia no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación. " +
            "Parámetro recibido: solicitudId=" + solicitudId
        );
    }
}
