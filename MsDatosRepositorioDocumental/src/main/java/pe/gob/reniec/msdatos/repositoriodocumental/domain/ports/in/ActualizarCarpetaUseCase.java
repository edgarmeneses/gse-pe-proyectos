package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;

/**
 * Puerto de entrada: Actualizar Carpeta
 * Define el contrato para actualizar una carpeta existente.
 */
public interface ActualizarCarpetaUseCase {

    /**
     * Actualiza una carpeta existente en el repositorio.
     *
     * @param id Identificador de la carpeta a actualizar
     * @param carpeta Carpeta con los datos actualizados
     * @return Carpeta actualizada con campos modificados y timestamp
     */
    Carpeta actualizar(String id, Carpeta carpeta);
}
