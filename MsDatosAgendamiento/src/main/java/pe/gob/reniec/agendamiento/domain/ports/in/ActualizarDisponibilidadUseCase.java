package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;

public interface ActualizarDisponibilidadUseCase {
    Disponibilidad actualizar(String disponibilidadId, Long capacidadTotal, String estado, String motivoCambio);
}
