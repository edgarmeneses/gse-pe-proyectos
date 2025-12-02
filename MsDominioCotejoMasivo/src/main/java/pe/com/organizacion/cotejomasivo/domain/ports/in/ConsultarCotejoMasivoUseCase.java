package pe.com.organizacion.cotejomasivo.domain.ports.in;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;

/**
 * Puerto de entrada: ConsultarCotejoMasivoUseCase
 * Caso de uso para consultar el estado de una ejecución de cotejo masivo
 */
public interface ConsultarCotejoMasivoUseCase {
    
    /**
     * Consulta el estado actual de una ejecución de cotejo masivo
     * 
     * @param idEjecucion Identificador único de la ejecución
     * @return CotejoMasivo con información actualizada del estado
     */
    CotejoMasivo consultar(String idEjecucion);
}
