package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;

/**
 * Puerto de entrada: Crear Documento
 * Define el contrato para la creación de un nuevo documento en el sistema.
 */
public interface CrearDocumentoUseCase {

    /**
     * Crea un nuevo documento en el repositorio documental.
     *
     * @param documento Documento a crear
     * @return Documento creado con ID y timestamp
     */
    Documento crear(Documento documento);
}
