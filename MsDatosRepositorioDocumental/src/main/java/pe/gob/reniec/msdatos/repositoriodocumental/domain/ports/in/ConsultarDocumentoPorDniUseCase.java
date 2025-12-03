package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import java.util.Map;

/**
 * Puerto de entrada: Consultar Documentos Por DNI
 * Define el contrato para consultar documentos asociados a un DNI de ciudadano.
 */
public interface ConsultarDocumentoPorDniUseCase {

    /**
     * Consulta documentos de un ciudadano por su DNI con filtros y paginación.
     *
     * @param dni DNI del ciudadano (8 dígitos)
     * @param filtros Mapa con filtros (tipoDocumento, fechaDesde, fechaHasta, estadoDocumento)
     * @param page Número de página
     * @param size Tamaño de página
     * @return Información del ciudadano, documentos y paginación
     */
    pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarDocumentoPorDniResponseDto consultarPorDni(String dni, Map<String, String> filtros, Integer page, Integer size);
}
