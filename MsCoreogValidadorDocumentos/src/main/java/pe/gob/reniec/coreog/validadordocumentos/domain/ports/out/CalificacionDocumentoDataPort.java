package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudCalificacion;

/**
 * Puerto de salida para operaciones de calificación de documentos hacia MsData
 * Este puerto abstrae la comunicación con el componente externo MsDataValidadorDocumentos
 * No define el protocolo de conexión (HTTP/SOAP/colas)
 */
public interface CalificacionDocumentoDataPort {
    
    /**
     * Envía una solicitud de calificación de documentos al componente de datos
     * 
     * @param solicitudCalificacion solicitud con documentos a calificar
     * @return evaluación resultante procesada por el componente de datos
     */
    EvaluacionDocumento procesarCalificacion(SolicitudCalificacion solicitudCalificacion);
    
    /**
     * Consulta el estado de una evaluación previamente procesada
     * 
     * @param evaluacionId identificador de la evaluación
     * @return evaluación con su estado actual
     */
    EvaluacionDocumento consultarEvaluacion(String evaluacionId);
}
