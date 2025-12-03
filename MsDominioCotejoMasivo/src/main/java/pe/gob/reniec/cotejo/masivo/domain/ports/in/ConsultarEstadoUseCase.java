package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;

public interface ConsultarEstadoUseCase {
    Ejecucion consultarEstado(String ejecucionId);
}
