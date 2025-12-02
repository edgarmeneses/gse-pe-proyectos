package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import java.util.UUID;

public interface ConsultarEjecucionUseCase {
    Ejecucion consultar(UUID ejecucionId);
}
