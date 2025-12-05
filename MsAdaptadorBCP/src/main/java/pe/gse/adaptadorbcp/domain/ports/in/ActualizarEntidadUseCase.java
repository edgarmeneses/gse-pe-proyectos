package pe.gse.adaptadorbcp.domain.ports.in;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;

public interface ActualizarEntidadUseCase {
    EntidadPlaceholder actualizar(Long id, EntidadPlaceholder entidad);
}
