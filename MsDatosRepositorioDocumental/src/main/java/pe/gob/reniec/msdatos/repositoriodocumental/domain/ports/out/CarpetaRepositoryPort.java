package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import java.util.Map;

/**
 * Puerto de salida: Repositorio de Carpetas
 * Define las operaciones de persistencia para carpetas.
 */
public interface CarpetaRepositoryPort {

    /**
     * Guarda una nueva carpeta en el repositorio.
     *
     * @param carpeta Carpeta a guardar
     * @return Carpeta guardada con ID y ruta asignados
     */
    Carpeta guardar(Carpeta carpeta);

    /**
     * Busca una carpeta por su identificador.
     *
     * @param id Identificador de la carpeta
     * @return Carpeta encontrada o null
     */
    Carpeta buscarPorId(String id);

    /**
     * Actualiza una carpeta existente.
     *
     * @param id Identificador de la carpeta
     * @param carpeta Carpeta con los datos a actualizar
     * @return Carpeta actualizada
     */
    Carpeta actualizar(String id, Carpeta carpeta);

    /**
     * Consulta el contenido de una carpeta (subcarpetas y documentos).
     *
     * @param id Identificador de la carpeta
     * @param filtros Mapa con criterios de filtrado
     * @param page Número de página
     * @param size Tamaño de página
     * @return Información de la carpeta, contenido y metadata de paginación
     */
    pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarCarpetaResponseDto consultarContenido(String id, Map<String, String> filtros, Integer page, Integer size);
}
