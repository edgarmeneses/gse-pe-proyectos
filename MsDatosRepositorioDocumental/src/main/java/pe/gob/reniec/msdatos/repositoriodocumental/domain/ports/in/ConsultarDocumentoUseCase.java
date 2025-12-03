package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;

/**
 * Puerto de entrada: Consultar Documento
 * Define el contrato para consultar un documento específico por su ID.
 */
public interface ConsultarDocumentoUseCase {

    /**
     * Consulta un documento por su identificador único.
     *
     * @param id Identificador del documento
     * @return Documento encontrado
     */
    Documento consultarPorId(String id);
}
