package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.externo.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.GestorDocumentalPort;

/**
 * Adaptador: Cliente para el Gestor Documental
 * Implementa la comunicación con el sistema de gestión documental
 * NO define el protocolo de conexión (sin HTTP, SOAP, colas, etc.)
 */
public class GestorDocumentalAdapter implements GestorDocumentalPort {
    
    @Override
    public byte[] obtenerDocumento(String rutaGestorDocumental) {
        // TODO: Implementar integración con Gestor Documental
        // Sin tecnología (sin protocolo HTTP/SOAP/colas definido)
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Gestor Documental");
    }
    
    @Override
    public Boolean verificarIntegridadDocumento(String rutaGestorDocumental, String hashSHA256) {
        // TODO: Implementar verificación de integridad
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Gestor Documental");
    }
    
    @Override
    public Boolean existeDocumento(String rutaGestorDocumental) {
        // TODO: Implementar verificación de existencia
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Gestor Documental");
    }
}
