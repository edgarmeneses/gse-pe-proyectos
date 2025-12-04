package pe.gob.reniec.datosparentesco.domain.ports.in;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;

/**
 * Puerto de entrada - Caso de uso para actualizar un análisis de parentesco.
 */
public interface ActualizarAnalisisUseCase {
    
    /**
     * Actualiza un análisis de parentesco existente.
     * 
     * @param idAnalisis Identificador del análisis a actualizar
     * @param analisisParentesco Datos actualizados del análisis
     * @return Análisis actualizado
     */
    AnalisisParentesco actualizar(String idAnalisis, AnalisisParentesco analisisParentesco);
}
