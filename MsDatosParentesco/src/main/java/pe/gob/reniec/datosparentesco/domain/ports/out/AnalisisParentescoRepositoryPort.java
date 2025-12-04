package pe.gob.reniec.datosparentesco.domain.ports.out;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.datosparentesco.domain.model.Paginacion;
import java.util.List;

/**
 * Puerto de salida - Interfaz del repositorio para operaciones de persistencia de análisis de parentesco.
 */
public interface AnalisisParentescoRepositoryPort {
    
    /**
     * Guarda un análisis de parentesco en la base de datos.
     * 
     * @param analisisParentesco Análisis a guardar
     * @return Análisis guardado con ID generado
     */
    AnalisisParentesco guardar(AnalisisParentesco analisisParentesco);
    
    /**
     * Busca un análisis de parentesco por su identificador.
     * 
     * @param idAnalisis Identificador del análisis
     * @return Análisis encontrado o null si no existe
     */
    AnalisisParentesco buscarPorId(String idAnalisis);
    
    /**
     * Clase que encapsula el resultado de la búsqueda con paginación.
     */
    class ResultadoBusqueda {
        private final List<AnalisisParentesco> analisis;
        private final Paginacion paginacion;
        
        public ResultadoBusqueda(List<AnalisisParentesco> analisis, Paginacion paginacion) {
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
     * Busca análisis de parentesco con filtros y paginación.
     * 
     * @param idCiudadano Filtro opcional por DNI de ciudadano
     * @param idSolicitud Filtro opcional por ID de solicitud
     * @param estado Filtro opcional por estado
     * @param tipoVinculo Filtro opcional por tipo de vínculo
     * @param fechaDesde Filtro opcional por fecha desde (ISO 8601)
     * @param fechaHasta Filtro opcional por fecha hasta (ISO 8601)
     * @param usuarioTecnico Filtro opcional por usuario técnico
     * @param pagina Número de página
     * @param tamanioPagina Tamaño de página
     * @return Resultado con lista de análisis y datos de paginación
     */
    ResultadoBusqueda buscar(String idCiudadano, String idSolicitud, String estado, 
                            String tipoVinculo, String fechaDesde, String fechaHasta, 
                            String usuarioTecnico, Integer pagina, Integer tamanioPagina);
    
    /**
     * Actualiza un análisis de parentesco existente.
     * 
     * @param analisisParentesco Análisis con datos actualizados
     * @return Análisis actualizado
     */
    AnalisisParentesco actualizar(AnalisisParentesco analisisParentesco);
    
    /**
     * Verifica si existe un análisis activo para un ciudadano.
     * 
     * @param idCiudadano DNI del ciudadano
     * @return true si existe un análisis activo, false en caso contrario
     */
    boolean existeAnalisisActivo(String idCiudadano);
}
