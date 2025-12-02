package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.protecciondocumentos.domain.model.ArchivoProtegido;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.GestorDocumentosDataPort;

/**
 * Adaptador cliente para integración con MsGestorDocumentos.
 * Este adaptador implementa los puertos de salida para gestionar documentos
 * (obtener y almacenar) en el microservicio de gestión documental externo.
 * 
 * NOTA: Esta implementación no define el protocolo de comunicación (HTTP, SOAP, mensajería, etc.)
 * ya que esto será definido en una capa de implementación tecnológica específica.
 */
public class GestorDocumentosDataAdapter implements GestorDocumentosDataPort {

    @Override
    public byte[] obtenerDocumento(String repositorioId, String documentoId, String versionId) {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsGestorDocumentos según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Integración con MsGestorDocumentos para obtener documento no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación. " +
            "Parámetros recibidos: repositorioId=" + repositorioId + 
            ", documentoId=" + documentoId + ", versionId=" + versionId
        );
    }

    @Override
    public ArchivoProtegido almacenarDocumentoProtegido(String nombreArchivo, byte[] contenido, String checksumSHA256) {
        // Esta implementación debe ser completada con la lógica de integración real
        // hacia MsGestorDocumentos según el protocolo que se defina.
        throw new UnsupportedOperationException(
            "Integración con MsGestorDocumentos para almacenar documento no implementada. " +
            "Se debe definir el mecanismo de comunicación (REST, SOAP, mensajería) " +
            "y completar esta implementación. " +
            "Parámetros recibidos: nombreArchivo=" + nombreArchivo + 
            ", tamaño contenido=" + (contenido != null ? contenido.length : 0) + " bytes"
        );
    }
}
