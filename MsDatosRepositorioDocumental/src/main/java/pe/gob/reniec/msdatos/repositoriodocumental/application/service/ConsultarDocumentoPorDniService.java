package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarDocumentoPorDniUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import java.util.Map;

/**
 * Servicio de aplicación: Consultar Documento Por DNI
 * Implementa la lógica de negocio para consultar documentos de un ciudadano.
 */
public class ConsultarDocumentoPorDniService implements ConsultarDocumentoPorDniUseCase {

    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ConsultarDocumentoPorDniService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarDocumentoPorDniResponseDto consultarPorDni(String dni, Map<String, String> filtros, Integer page, Integer size) {
        // Aquí iría validación del formato DNI (8 dígitos)
        return documentoRepositoryPort.buscarPorDni(dni, filtros, page, size);
    }
}
