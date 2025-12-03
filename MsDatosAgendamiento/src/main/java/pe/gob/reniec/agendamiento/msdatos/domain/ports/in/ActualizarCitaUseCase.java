package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;

public interface ActualizarCitaUseCase {
    Cita actualizar(String citaId, Cita citaActualizada);
}
