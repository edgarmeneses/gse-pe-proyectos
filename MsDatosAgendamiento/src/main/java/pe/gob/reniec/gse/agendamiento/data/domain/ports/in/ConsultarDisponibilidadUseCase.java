package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import java.time.LocalDate;
import java.util.List;

public interface ConsultarDisponibilidadUseCase {
    
    List<Disponibilidad> consultar(String codigoSede, LocalDate fechaDesde, LocalDate fechaHasta, Boolean soloDisponibles);
}
