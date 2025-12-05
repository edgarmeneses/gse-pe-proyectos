package pe.gse.adaptadorbcp.domain.ports.in;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;

public interface ConsultarEntidadUseCase {
    EntidadPlaceholder consultarPorId(Long id);
}
