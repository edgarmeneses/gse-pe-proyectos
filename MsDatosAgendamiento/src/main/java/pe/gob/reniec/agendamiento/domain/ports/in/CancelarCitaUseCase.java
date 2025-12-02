package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.Cita;

public interface CancelarCitaUseCase {
    Cita cancelar(String citaId, String motivoCancelacion, String tokenReagendamiento, String observaciones);
}
