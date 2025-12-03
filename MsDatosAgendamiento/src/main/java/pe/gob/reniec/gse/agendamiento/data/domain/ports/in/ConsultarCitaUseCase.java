package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.model.HistorialCita;
import java.util.List;

public interface ConsultarCitaUseCase {
    
    Cita consultar(String citaId, Boolean incluirHistorial);
    
    List<HistorialCita> consultarHistorial(String citaId);
}
