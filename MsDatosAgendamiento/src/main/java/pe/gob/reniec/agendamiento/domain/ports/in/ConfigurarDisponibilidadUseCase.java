package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.domain.model.SedeServicio;
import pe.gob.reniec.agendamiento.domain.model.HorarioServicio;
import java.util.List;

public interface ConfigurarDisponibilidadUseCase {
    Disponibilidad configurar(SedeServicio sedeServicio, List<HorarioServicio> horarioServicio, String fechaDesde, String fechaHasta, Boolean generarDisponibilidadAutomatica);
}
