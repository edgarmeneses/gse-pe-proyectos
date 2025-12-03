package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import java.util.Map;

/**
 * Puerto de entrada: Consultar Carpeta
 * Define el contrato para consultar el contenido de una carpeta.
 */
public interface ConsultarCarpetaUseCase {

    /**
     * Consulta el contenido de una carpeta (subcarpetas y documentos).
     *
     * @param id Identificador de la carpeta
     * @param filtros Mapa con parámetros de filtrado (queryParam1, queryParam2, queryParam3)
     * @param page Número de página
     * @param size Tamaño de página
     * @return Información de la carpeta, contenido y paginación
     */
    pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarCarpetaResponseDto consultarContenido(String id, Map<String, String> filtros, Integer page, Integer size);
}
