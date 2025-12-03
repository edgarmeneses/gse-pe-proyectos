package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;

public interface ConsultarCitaUseCase {
    Cita consultar(String citaId, Boolean incluirHistorial);
}
