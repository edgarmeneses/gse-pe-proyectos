package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;

public interface ActualizarDisponibilidadUseCase {
    
    Disponibilidad actualizar(String disponibilidadId, Integer capacidadTotal, String estado, String motivoCambio);
}
