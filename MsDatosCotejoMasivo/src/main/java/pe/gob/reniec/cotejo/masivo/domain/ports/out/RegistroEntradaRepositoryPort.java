package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import java.util.List;
import java.util.UUID;

public interface RegistroEntradaRepositoryPort {
    List<RegistroEntrada> guardarLote(List<RegistroEntrada> registros);
    RegistroEntrada buscarPorId(UUID registroEntradaId);
    List<RegistroEntrada> buscarPorEjecucionId(UUID ejecucionId);
}
