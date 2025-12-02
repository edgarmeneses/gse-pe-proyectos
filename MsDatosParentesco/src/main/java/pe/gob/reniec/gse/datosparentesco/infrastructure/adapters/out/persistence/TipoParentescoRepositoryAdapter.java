package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence;

import pe.gob.reniec.gse.datosparentesco.domain.model.TipoParentesco;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.TipoParentescoRepositoryPort;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence.mapper.TipoParentescoPersistenceMapper;
import java.util.List;

public class TipoParentescoRepositoryAdapter implements TipoParentescoRepositoryPort {
    private final TipoParentescoPersistenceMapper tipoParentescoPersistenceMapper;

    public TipoParentescoRepositoryAdapter(TipoParentescoPersistenceMapper tipoParentescoPersistenceMapper) {
        this.tipoParentescoPersistenceMapper = tipoParentescoPersistenceMapper;
    }

    @Override
    public List<TipoParentesco> listarTodos() {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
