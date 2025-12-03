package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.RegistroEntradaRepositoryPort;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper.RegistroEntradaPersistenceMapper;

import java.util.List;

public class RegistroEntradaRepositoryAdapter implements RegistroEntradaRepositoryPort {
    private final RegistroEntradaPersistenceMapper mapper;

    public RegistroEntradaRepositoryAdapter(RegistroEntradaPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<RegistroEntrada> crearBatch(List<RegistroEntrada> registros) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public RegistroEntrada consultarPorId(String registroEntradaId) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public List<RegistroEntrada> listarPorEjecucion(String ejecucionId) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }
}
