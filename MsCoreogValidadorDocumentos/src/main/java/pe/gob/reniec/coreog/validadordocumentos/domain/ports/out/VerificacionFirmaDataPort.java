package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudVerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.VerificacionFirma;

/**
 * Puerto de salida para operaciones de verificación de firmas hacia MsData
 * Este puerto abstrae la comunicación con el componente externo MsDataValidadorDocumentos
 * No define el protocolo de conexión (HTTP/SOAP/colas)
 */
public interface VerificacionFirmaDataPort {
    
    /**
     * Envía una solicitud de verificación de firma al componente de datos
     * 
     * @param solicitudVerificacion solicitud con datos de firma a verificar
     * @return verificación resultante procesada por el componente de datos
     */
    VerificacionFirma procesarVerificacion(SolicitudVerificacionFirma solicitudVerificacion);
    
    /**
     * Consulta el estado de una verificación previamente procesada
     * 
     * @param verificacionId identificador de la verificación
     * @return verificación con su estado actual
     */
    VerificacionFirma consultarVerificacion(String verificacionId);
}
