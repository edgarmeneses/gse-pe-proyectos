package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;

/**
 * Puerto de entrada: Crear Carpeta
 * Define el contrato para crear una nueva carpeta en el sistema.
 */
public interface CrearCarpetaUseCase {

    /**
     * Crea una nueva carpeta en el repositorio documental.
     *
     * @param carpeta Carpeta a crear
     * @return Carpeta creada con ID, ruta y timestamp
     */
    Carpeta crear(Carpeta carpeta);
}
