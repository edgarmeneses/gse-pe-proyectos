package pe.gob.reniec.coreog.validadordocumentos.domain.ports.in;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudVerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.VerificacionFirma;

/**
 * Puerto de entrada para el caso de uso de verificar firma del registrador
 */
public interface VerificarFirmaRegistradorUseCase {
    
    /**
     * Verifica la validez de la firma digital de un registrador
     * 
     * @param solicitudVerificacion solicitud con los datos de la firma a verificar
     * @return resultado de la verificación con estado y alertas
     */
    VerificacionFirma verificar(SolicitudVerificacionFirma solicitudVerificacion);
}
