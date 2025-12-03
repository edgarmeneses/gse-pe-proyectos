package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;

/**
 * Puerto de entrada: Actualizar Documento
 * Define el contrato para actualizar un documento existente.
 */
public interface ActualizarDocumentoUseCase {

    /**
     * Actualiza un documento existente en el repositorio.
     *
     * @param id Identificador del documento a actualizar
     * @param documento Documento con los datos actualizados
     * @return Documento actualizado con campos modificados y timestamp
     */
    Documento actualizar(String id, Documento documento);
}
