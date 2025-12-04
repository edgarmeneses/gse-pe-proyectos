package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import pe.gob.onpe.datos.electoral.domain.ports.out.ImpugnacionRepositoryPort;

import java.util.List;

public class ImpugnacionRepositoryAdapter implements ImpugnacionRepositoryPort {

    @Override
    public Impugnacion findById(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public List<Impugnacion> findAll() {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
