package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.RegistroEntradaRepositoryPort;
import java.util.List;
import java.util.UUID;

public class RegistroEntradaRepositoryAdapter implements RegistroEntradaRepositoryPort {

    @Override
    public List<RegistroEntrada> guardarLote(List<RegistroEntrada> registros) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public RegistroEntrada buscarPorId(UUID registroEntradaId) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public List<RegistroEntrada> buscarPorEjecucionId(UUID ejecucionId) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }
}
