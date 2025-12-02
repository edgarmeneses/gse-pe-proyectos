package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.Cita;

public interface ConsultarCitaUseCase {
    Cita consultar(String citaId, Boolean incluirHistorial);
}
