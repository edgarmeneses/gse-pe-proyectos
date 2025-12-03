package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;

public interface CrearCitaUseCase {
    
    Cita crear(Cita cita);
}
