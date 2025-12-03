package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.List;
import java.util.Map;

/**
 * Puerto de salida: Repositorio de Documentos
 * Define las operaciones de persistencia para documentos.
 */
public interface DocumentoRepositoryPort {

    /**
     * Guarda un nuevo documento en el repositorio.
     *
     * @param documento Documento a guardar
     * @return Documento guardado con ID asignado
     */
    Documento guardar(Documento documento);

    /**
     * Busca un documento por su identificador.
     *
     * @param id Identificador del documento
     * @return Documento encontrado o null
     */
    Documento buscarPorId(String id);

    /**
     * Actualiza un documento existente.
     *
     * @param id Identificador del documento
     * @param documento Documento con los datos a actualizar
     * @return Documento actualizado
     */
    Documento actualizar(String id, Documento documento);

    /**
     * Lista documentos aplicando filtros y paginación.
     *
     * @param filtros Mapa con criterios de filtrado
     * @param page Número de página
     * @param size Tamaño de página
     * @return Lista de documentos y metadata de paginación
     */
    pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ListarDocumentosResponseDto listar(Map<String, String> filtros, Integer page, Integer size);

    /**
     * Busca documentos asociados a un DNI de ciudadano.
     *
     * @param dni DNI del ciudadano
     * @param filtros Mapa con criterios de filtrado adicionales
     * @param page Número de página
     * @param size Tamaño de página
     * @return Documentos del ciudadano y metadata de paginación
     */
    pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarDocumentoPorDniResponseDto buscarPorDni(String dni, Map<String, String> filtros, Integer page, Integer size);
}
