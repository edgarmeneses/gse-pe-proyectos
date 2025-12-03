package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Evaluacion;

/**
 * Puerto de salida: Comunicación con MsDataValidadorDocumentos para persistir evaluaciones
 * Este es un microservicio de DOMINIO, por lo que NO define RepositoryPort.
 * Define puertos de salida hacia MsData para operaciones de persistencia.
 */
public interface EvaluacionDataPort {
    
    /**
     * Guarda una evaluación de documentos en el sistema de datos
     * 
     * @param evaluacion Evaluación a guardar
     * @return Evaluación guardada con el ID generado
     */
    Evaluacion guardarEvaluacion(Evaluacion evaluacion);
    
    /**
     * Consulta una evaluación por su ID
     * 
     * @param evaluacionId ID de la evaluación
     * @return Evaluación encontrada o null si no existe
     */
    Evaluacion consultarEvaluacionPorId(String evaluacionId);
    
    /**
     * Consulta evaluaciones por solicitud
     * 
     * @param solicitudId ID de la solicitud
     * @return Lista de evaluaciones de la solicitud
     */
    java.util.List<Evaluacion> consultarEvaluacionesPorSolicitud(String solicitudId);
}
