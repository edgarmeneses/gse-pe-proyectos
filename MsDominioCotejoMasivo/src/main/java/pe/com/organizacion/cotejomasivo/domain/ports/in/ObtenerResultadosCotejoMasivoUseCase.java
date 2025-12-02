package pe.com.organizacion.cotejomasivo.domain.ports.in;

import pe.com.organizacion.cotejomasivo.domain.model.ResultadosPaginados;

/**
 * Puerto de entrada: ObtenerResultadosCotejoMasivoUseCase
 * Caso de uso para obtener los resultados detallados de un cotejo masivo
 */
public interface ObtenerResultadosCotejoMasivoUseCase {
    
    /**
     * Obtiene los resultados paginados de una ejecución de cotejo masivo
     * 
     * @param idEjecucion Identificador único de la ejecución
     * @param pagina Número de página (iniciando en 0)
     * @param tamanio Tamaño de página
     * @param estadoCotejo Filtro opcional por estado de cotejo
     * @return ResultadosPaginados con los resultados del cotejo
     */
    ResultadosPaginados obtenerResultados(String idEjecucion, Long pagina, Long tamanio, String estadoCotejo);
}
