package pe.gob.reniec.datosparentesco.domain.ports.in;

import pe.gob.reniec.datosparentesco.domain.model.RelacionParentesco;

/**
 * Puerto de entrada - Caso de uso para registrar una relación de parentesco.
 */
public interface RegistrarRelacionUseCase {
    
    /**
     * Registra una nueva relación de parentesco entre dos ciudadanos.
     * 
     * @param relacionParentesco Datos de la relación a registrar
     * @return Relación registrada con ID generado e información de relación inversa
     */
    RelacionParentesco registrar(RelacionParentesco relacionParentesco);
}
