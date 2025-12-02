package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;

public interface CrearEjecucionUseCase {
    Ejecucion crear(Ejecucion ejecucion);
}
