package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;

public interface ActualizarDisponibilidadUseCase {
    Disponibilidad actualizar(String disponibilidadId, Integer capacidadTotal, 
                              String estado, String motivoCambio);
}
