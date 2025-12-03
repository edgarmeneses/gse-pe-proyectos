package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import java.util.List;

public interface ConsultarDisponibilidadUseCase {
    List<Disponibilidad> consultar(String codigoSede, String fechaDesde, String fechaHasta, Boolean soloDisponibles);
}
