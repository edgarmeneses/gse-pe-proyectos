package pe.gob.reniec.padronelectoral.domain.ports.out;

import pe.gob.reniec.padronelectoral.domain.model.Ciudadano;
import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.model.PaginatedResult;
import java.util.List;

/**
 * Puerto de salida unificado hacia MsDataPadronElectoral.
 * Define las operaciones necesarias para interactuar con el componente de datos
 * sin especificar el protocolo de comunicación (HTTP/SOAP/Colas).
 */
public interface PadronElectoralDataPort {
    
    /**
     * Crea un nuevo padrón electoral en MsDataPadronElectoral.
     * 
     * @param tipoPadron Tipo de padrón a crear
     * @param departamento Departamento de la circunscripción
     * @param provincia Provincia de la circunscripción
     * @param distrito Distrito de la circunscripción
     * @return PadronElectoral creado con lista de ciudadanos generada
     */
    PadronElectoral crearPadron(String tipoPadron, String departamento, String provincia, String distrito);
    
    /**
     * Actualiza un padrón electoral existente en MsDataPadronElectoral.
     * 
     * @param id Identificador del padrón a actualizar
     * @param usuarioResponsableId Identificador del usuario responsable
     * @param tipoPadron Tipo de padrón
     * @param informeFinalVerificacionDomicilioId Identificador del informe de verificación
     * @param tipoVerificacion Tipo de verificación realizada
     * @return PadronElectoral actualizado
     */
    PadronElectoral actualizarPadron(String id, String usuarioResponsableId, String tipoPadron, 
                                     String informeFinalVerificacionDomicilioId, String tipoVerificacion);
    
    /**
     * Lista padrones electorales con filtros y paginación desde MsDataPadronElectoral.
     * 
     * @param texto Texto para filtrado (opcional)
     * @param fecha Fecha para filtrado (opcional)
     * @param queryParam3 Parámetro adicional de filtrado (opcional)
     * @param page Número de página
     * @param size Tamaño de página
     * @return Resultado paginado con lista de padrones
     */
    PaginatedResult<PadronElectoral> listarPadrones(String texto, String fecha, String queryParam3, 
                                                     Integer page, Integer size);
    
    /**
     * Consulta un padrón electoral específico por ID desde MsDataPadronElectoral.
     * 
     * @param id Identificador del padrón
     * @param page Número de página para ciudadanos
     * @param size Tamaño de página para ciudadanos
     * @return PadronElectoral con información completa incluyendo actualizaciones
     */
    PadronElectoral consultarPadronPorId(String id, Integer page, Integer size);
    
    /**
     * Obtiene lista paginada de ciudadanos de un padrón específico.
     * 
     * @param idPadron Identificador del padrón
     * @param page Número de página
     * @param size Tamaño de página
     * @return Lista paginada de ciudadanos
     */
    List<Ciudadano> obtenerCiudadanosPaginados(String idPadron, Integer page, Integer size);
}
