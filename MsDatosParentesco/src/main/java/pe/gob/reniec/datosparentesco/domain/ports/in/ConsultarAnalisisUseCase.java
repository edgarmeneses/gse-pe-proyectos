package pe.gob.reniec.datosparentesco.domain.ports.in;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;

/**
 * Puerto de entrada - Caso de uso para consultar un análisis de parentesco por ID.
 */
public interface ConsultarAnalisisUseCase {
    
    /**
     * Consulta un análisis de parentesco por su identificador.
     * 
     * @param idAnalisis Identificador del análisis
     * @return Análisis encontrado o null si no existe
     */
    AnalisisParentesco consultarPorId(String idAnalisis);
}
