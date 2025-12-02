package pe.gob.reniec.gse.datosparentesco.domain.ports.out;

import pe.gob.reniec.gse.datosparentesco.domain.model.TipoParentesco;
import java.util.List;

public interface TipoParentescoRepositoryPort {
    List<TipoParentesco> listarTodos();
}
