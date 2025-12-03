package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import java.util.List;

public interface RegistroEntradaRepositoryPort {
    List<RegistroEntrada> crearBatch(List<RegistroEntrada> registros);
    RegistroEntrada consultarPorId(String registroEntradaId);
    List<RegistroEntrada> listarPorEjecucion(String ejecucionId);
}
