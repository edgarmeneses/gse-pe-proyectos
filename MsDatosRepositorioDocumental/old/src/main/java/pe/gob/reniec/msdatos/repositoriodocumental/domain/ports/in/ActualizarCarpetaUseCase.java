package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;

public interface ActualizarCarpetaUseCase {
    Carpeta actualizar(String id, String nombre, String estadoCarpeta, 
                      String parentId, String descripcion);
}
