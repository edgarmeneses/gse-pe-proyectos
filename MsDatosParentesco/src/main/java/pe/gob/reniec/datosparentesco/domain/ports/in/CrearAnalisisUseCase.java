package pe.gob.reniec.datosparentesco.domain.ports.in;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;

/**
 * Puerto de entrada - Caso de uso para crear un análisis de parentesco.
 */
public interface CrearAnalisisUseCase {
    
    /**
     * Crea un nuevo análisis de parentesco.
     * 
     * @param analisisParentesco Datos del análisis a crear
     * @return Análisis creado con ID generado
     */
    AnalisisParentesco crear(AnalisisParentesco analisisParentesco);
}
