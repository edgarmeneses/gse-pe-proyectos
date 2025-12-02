package pe.gob.reniec.coreog.validadordocumentos.application.service;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudVerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.VerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.in.VerificarFirmaRegistradorUseCase;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.VerificacionFirmaDataPort;

/**
 * Servicio de aplicación que implementa el caso de uso de verificar firma del registrador
 */
public class VerificarFirmaRegistradorService implements VerificarFirmaRegistradorUseCase {
    
    private final VerificacionFirmaDataPort verificacionFirmaDataPort;
    
    public VerificarFirmaRegistradorService(VerificacionFirmaDataPort verificacionFirmaDataPort) {
        this.verificacionFirmaDataPort = verificacionFirmaDataPort;
    }
    
    @Override
    public VerificacionFirma verificar(SolicitudVerificacionFirma solicitudVerificacion) {
        // Lógica de negocio para validar la solicitud y preparar la verificación
        // Por ahora, se delega directamente al puerto de salida
        return verificacionFirmaDataPort.procesarVerificacion(solicitudVerificacion);
    }
}
