package pe.gob.reniec.gse.registradores.domain.ports.in;

import pe.gob.reniec.gse.registradores.domain.model.Registrador;

/**
 * Puerto de entrada: Consultar Registrador
 * Define el contrato para obtener información detallada de un registrador específico.
 */
public interface ConsultarRegistradorUseCase {
    
    /**
     * Consulta la información detallada de un registrador específico.
     * 
     * @param idRegistrador El identificador único del registrador
     * @return El registrador con toda su información detallada
     */
    Registrador consultarPorId(String idRegistrador);
}
