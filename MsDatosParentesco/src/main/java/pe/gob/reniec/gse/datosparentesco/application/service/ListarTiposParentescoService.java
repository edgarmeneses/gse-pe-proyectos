package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.TipoParentesco;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ListarTiposParentescoUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.TipoParentescoRepositoryPort;
import java.util.List;

public class ListarTiposParentescoService implements ListarTiposParentescoUseCase {
    private final TipoParentescoRepositoryPort tipoParentescoRepositoryPort;

    public ListarTiposParentescoService(TipoParentescoRepositoryPort tipoParentescoRepositoryPort) {
        this.tipoParentescoRepositoryPort = tipoParentescoRepositoryPort;
    }

    @Override
    public List<TipoParentesco> listarTodos() {
        return tipoParentescoRepositoryPort.listarTodos();
    }
}
