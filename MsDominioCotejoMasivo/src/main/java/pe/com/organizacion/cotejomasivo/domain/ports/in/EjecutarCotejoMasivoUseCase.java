package pe.com.organizacion.cotejomasivo.domain.ports.in;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.model.CriterioCotejo;

import java.util.List;

/**
 * Puerto de entrada: EjecutarCotejoMasivoUseCase
 * Caso de uso para iniciar un proceso de cotejo masivo
 */
public interface EjecutarCotejoMasivoUseCase {
    
    /**
     * Ejecuta un nuevo proceso de cotejo masivo
     * 
     * @param criteriosCotejo Lista de criterios para el cotejo
     * @param usuarioSolicitante Usuario que solicita el cotejo
     * @return CotejoMasivo iniciado con estado PENDIENTE
     */
    CotejoMasivo ejecutar(List<CriterioCotejo> criteriosCotejo, String usuarioSolicitante);
}
