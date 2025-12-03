package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Documento;

/**
 * Puerto de salida: Comunicación con el Gestor Documental para obtener documentos
 * Este puerto permite obtener los archivos de documentos desde el sistema de almacenamiento
 */
public interface GestorDocumentalPort {
    
    /**
     * Obtiene un documento desde el gestor documental
     * 
     * @param rutaGestorDocumental Ruta del documento en el gestor
     * @return Contenido del documento en bytes
     */
    byte[] obtenerDocumento(String rutaGestorDocumental);
    
    /**
     * Verifica la integridad de un documento usando su hash SHA256
     * 
     * @param rutaGestorDocumental Ruta del documento
     * @param hashSHA256 Hash esperado
     * @return true si el hash coincide, false en caso contrario
     */
    Boolean verificarIntegridadDocumento(String rutaGestorDocumental, String hashSHA256);
    
    /**
     * Verifica si un documento existe en el gestor documental
     * 
     * @param rutaGestorDocumental Ruta del documento
     * @return true si existe, false en caso contrario
     */
    Boolean existeDocumento(String rutaGestorDocumental);
}
