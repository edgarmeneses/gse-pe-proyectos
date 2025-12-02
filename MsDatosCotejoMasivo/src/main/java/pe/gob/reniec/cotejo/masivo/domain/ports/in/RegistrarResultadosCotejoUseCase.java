package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import java.util.List;
import java.util.UUID;

public interface RegistrarResultadosCotejoUseCase {
    List<ResultadoCotejo> registrar(UUID ejecucionId, List<ResultadoCotejo> resultados);
}
