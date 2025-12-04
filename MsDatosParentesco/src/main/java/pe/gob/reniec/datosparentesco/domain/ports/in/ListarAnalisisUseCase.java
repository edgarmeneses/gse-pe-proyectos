package pe.gob.reniec.datosparentesco.domain.ports.in;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.datosparentesco.domain.model.Paginacion;
import java.util.List;

/**
 * Puerto de entrada - Caso de uso para listar análisis de parentesco con filtros y paginación.
 */
public interface ListarAnalisisUseCase {
    
    /**
     * Clase que encapsula el resultado de la lista con paginación.
     */
    class ResultadoLista {
        private final List<AnalisisParentesco> analisis;
        private final Paginacion paginacion;
        
        public ResultadoLista(List<AnalisisParentesco> analisis, Paginacion paginacion) {
            this.analisis = analisis;
            this.paginacion = paginacion;
        }
        
        public List<AnalisisParentesco> getAnalisis() {
            return analisis;
        }
        
        public Paginacion getPaginacion() {
            return paginacion;
        }
    }
    
    /**
     * Lista análisis de parentesco con filtros opcionales y paginación.
     * 
     * @param idCiudadano Filtro opcional por DNI de ciudadano
     * @param idSolicitud Filtro opcional por ID de solicitud
     * @param estado Filtro opcional por estado
     * @param tipoVinculo Filtro opcional por tipo de vínculo
     * @param fechaDesde Filtro opcional por fecha desde
     * @param fechaHasta Filtro opcional por fecha hasta
     * @param usuarioTecnico Filtro opcional por usuario técnico
     * @param pagina Número de página
     * @param tamanioPagina Tamaño de página
     * @return Resultado con lista de análisis y datos de paginación
     */
    ResultadoLista listar(String idCiudadano, String idSolicitud, String estado, 
                         String tipoVinculo, String fechaDesde, String fechaHasta, 
                         String usuarioTecnico, Integer pagina, Integer tamanioPagina);
}
