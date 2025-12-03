package pe.gob.reniec.coreog.validadordocumentos.domain.ports.in;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudCalificacion;

/**
 * Puerto de entrada para el caso de uso de calificar documentos
 */
public interface CalificarDocumentoUseCase {
    
    /**
     * Califica uno o más documentos digitales aplicando modelos de IA
     * 
     * @param solicitudCalificacion solicitud con los documentos a calificar
     * @return resultado de la evaluación con scores y observaciones
     */
    EvaluacionDocumento calificar(SolicitudCalificacion solicitudCalificacion);
}
