package pe.gob.reniec.gse.datosparentesco.domain.ports.in;

import pe.gob.reniec.gse.datosparentesco.domain.model.TipoParentesco;
import java.util.List;

public interface ListarTiposParentescoUseCase {
    List<TipoParentesco> listarTodos();
}
