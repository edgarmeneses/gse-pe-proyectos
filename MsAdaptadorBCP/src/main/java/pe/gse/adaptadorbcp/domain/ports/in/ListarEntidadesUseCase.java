package pe.gse.adaptadorbcp.domain.ports.in;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;

import java.util.List;

public interface ListarEntidadesUseCase {
    List<EntidadPlaceholder> listar();
}
