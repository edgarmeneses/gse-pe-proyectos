package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;

public interface CrearCarpetaUseCase {
    Carpeta crear(String nombre, String parentId, String descripcion);
}
