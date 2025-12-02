package pe.com.organizacion.cotejomasivo.domain.ports.out;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.model.ResultadosPaginados;

/**
 * Puerto de salida: CotejoMasivoDataPort
 * Define las operaciones para integración con MsDataCotejoMasivo (microservicio de datos)
 */
public interface CotejoMasivoDataPort {
    
    /**
     * Crea un nuevo registro de ejecución de cotejo masivo en MsDataCotejoMasivo
     * 
     * @param cotejoMasivo Datos del cotejo masivo a crear
     * @return CotejoMasivo creado con identificador asignado
     */
    CotejoMasivo crear(CotejoMasivo cotejoMasivo);
    
    /**
     * Actualiza el estado de una ejecución de cotejo masivo en MsDataCotejoMasivo
     * 
     * @param cotejoMasivo Datos actualizados del cotejo masivo
     * @return CotejoMasivo actualizado
     */
    CotejoMasivo actualizar(CotejoMasivo cotejoMasivo);
    
    /**
     * Consulta una ejecución de cotejo masivo por su identificador desde MsDataCotejoMasivo
     * 
     * @param idEjecucion Identificador único de la ejecución
     * @return CotejoMasivo encontrado o null si no existe
     */
    CotejoMasivo consultarPorId(String idEjecucion);
    
    /**
     * Obtiene los resultados paginados de un cotejo masivo desde MsDataCotejoMasivo
     * 
     * @param idEjecucion Identificador único de la ejecución
     * @param pagina Número de página
     * @param tamanio Tamaño de página
     * @param estadoCotejo Filtro opcional por estado
     * @return ResultadosPaginados con los resultados del cotejo
     */
    ResultadosPaginados obtenerResultados(String idEjecucion, Long pagina, Long tamanio, String estadoCotejo);
}
