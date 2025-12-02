package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity.DocumentoEntity;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.mapper.DocumentoPersistenceMapper;
import java.util.List;

public class DocumentoRepositoryAdapter implements DocumentoRepositoryPort {

    @Override
    public Documento guardar(Documento documento) {
        throw new UnsupportedOperationException("Operación guardar documento no implementada");
    }

    @Override
    public Documento buscarPorId(String id) {
        throw new UnsupportedOperationException("Operación buscar documento por ID no implementada");
    }

    @Override
    public Documento actualizar(Documento documento) {
        throw new UnsupportedOperationException("Operación actualizar documento no implementada");
    }

    @Override
    public List<Documento> listar(String queryParam1, String queryParam2, String queryParam3, 
                                 Integer page, Integer size) {
        throw new UnsupportedOperationException("Operación listar documentos no implementada");
    }

    @Override
    public List<Documento> buscarPorDni(String dni, String tipoDocumento, String fechaDesde, 
                                       String fechaHasta, String estadoDocumento, 
                                       Integer page, Integer size) {
        throw new UnsupportedOperationException("Operación buscar por DNI no implementada");
    }
}
