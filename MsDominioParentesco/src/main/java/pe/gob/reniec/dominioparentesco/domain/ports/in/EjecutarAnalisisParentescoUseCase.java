package pe.gob.reniec.dominioparentesco.domain.ports.in;

import pe.gob.reniec.dominioparentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.dominioparentesco.domain.model.DNI;
import pe.gob.reniec.dominioparentesco.domain.model.TipoVinculo;

/**
 * Puerto de entrada - Caso de uso para ejecutar análisis de parentesco.
 * Representa el punto de entrada principal del microservicio MsDominioParentesco.
 */
public interface EjecutarAnalisisParentescoUseCase {
    
    /**
     * Ejecuta el análisis completo de vínculos de parentesco para un ciudadano.
     * 
     * @param dniCiudadano DNI del ciudadano a analizar
     * @param tipoVinculoBuscado Tipo de vínculo que se desea analizar
     * @param profundidadAnalisis Profundidad del análisis (grados: 1-4)
     * @param usuarioSolicitante Usuario técnico que solicita el análisis
     * @return Aggregate Root con el análisis completo y resultados
     */
    AnalisisParentesco ejecutar(DNI dniCiudadano, TipoVinculo tipoVinculoBuscado,
                                int profundidadAnalisis, String usuarioSolicitante);
}
