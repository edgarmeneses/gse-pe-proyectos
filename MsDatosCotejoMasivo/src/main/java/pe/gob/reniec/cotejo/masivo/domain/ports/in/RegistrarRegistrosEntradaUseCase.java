package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import java.util.List;
import java.util.UUID;

public interface RegistrarRegistrosEntradaUseCase {
    List<RegistroEntrada> registrar(UUID ejecucionId, List<RegistroEntrada> registros);
}
