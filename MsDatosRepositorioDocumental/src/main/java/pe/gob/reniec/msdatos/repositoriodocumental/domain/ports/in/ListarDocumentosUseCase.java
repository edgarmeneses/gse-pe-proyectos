package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Pagina;
import java.util.List;
import java.util.Map;

/**
 * Puerto de entrada: Listar Documentos
 * Define el contrato para listar documentos con filtros y paginación.
 */
public interface ListarDocumentosUseCase {

    /**
     * Lista documentos aplicando filtros y paginación.
     *
     * @param filtros Mapa con parámetros de filtrado (queryParam1, queryParam2, queryParam3)
     * @param page Número de página
     * @param size Tamaño de página
     * @return Lista de documentos con información de paginación
     */
    pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ListarDocumentosResponseDto listar(Map<String, String> filtros, Integer page, Integer size);
}
