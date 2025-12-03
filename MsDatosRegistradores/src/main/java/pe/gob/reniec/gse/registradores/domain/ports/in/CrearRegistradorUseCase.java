package pe.gob.reniec.gse.registradores.domain.ports.in;

import pe.gob.reniec.gse.registradores.domain.model.Registrador;

/**
 * Puerto de entrada: Crear Registrador
 * Define el contrato para crear un nuevo registrador en el sistema.
 */
public interface CrearRegistradorUseCase {
    
    /**
     * Crea un nuevo registrador civil en el sistema.
     * 
     * @param registrador El registrador a crear
     * @return El registrador creado con información adicional del sistema
     */
    Registrador crear(Registrador registrador);
}
