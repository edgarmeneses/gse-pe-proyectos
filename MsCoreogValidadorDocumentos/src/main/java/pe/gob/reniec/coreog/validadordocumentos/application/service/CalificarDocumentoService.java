package pe.gob.reniec.coreog.validadordocumentos.application.service;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudCalificacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.in.CalificarDocumentoUseCase;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.CalificacionDocumentoDataPort;

/**
 * Servicio de aplicación que implementa el caso de uso de calificar documentos
 */
public class CalificarDocumentoService implements CalificarDocumentoUseCase {
    
    private final CalificacionDocumentoDataPort calificacionDocumentoDataPort;
    
    public CalificarDocumentoService(CalificacionDocumentoDataPort calificacionDocumentoDataPort) {
        this.calificacionDocumentoDataPort = calificacionDocumentoDataPort;
    }
    
    @Override
    public EvaluacionDocumento calificar(SolicitudCalificacion solicitudCalificacion) {
        // Lógica de negocio para validar la solicitud y preparar el procesamiento
        // Por ahora, se delega directamente al puerto de salida
        return calificacionDocumentoDataPort.procesarCalificacion(solicitudCalificacion);
    }
}
