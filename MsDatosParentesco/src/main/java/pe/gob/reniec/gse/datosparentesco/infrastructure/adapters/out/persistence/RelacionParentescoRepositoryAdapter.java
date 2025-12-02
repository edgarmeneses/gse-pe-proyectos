package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.RelacionParentescoRepositoryPort;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence.mapper.RelacionParentescoPersistenceMapper;
import java.util.List;

public class RelacionParentescoRepositoryAdapter implements RelacionParentescoRepositoryPort {
    private final RelacionParentescoPersistenceMapper relacionParentescoPersistenceMapper;

    public RelacionParentescoRepositoryAdapter(RelacionParentescoPersistenceMapper relacionParentescoPersistenceMapper) {
        this.relacionParentescoPersistenceMapper = relacionParentescoPersistenceMapper;
    }

    @Override
    public RelacionParentesco guardar(RelacionParentesco relacionParentesco) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public List<RelacionParentesco> consultarPorCiudadano(String idCiudadano, String tipoParentesco,
                                                           Integer gradoMaximo, Boolean incluirInactivos) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
