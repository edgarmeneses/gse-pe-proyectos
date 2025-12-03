package pe.gob.reniec.agendamiento.domain.ports.out;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.domain.model.SedeServicio;
import pe.gob.reniec.agendamiento.domain.model.HorarioServicio;
import java.util.List;

public interface DisponibilidadRepositoryPort {
    List<Disponibilidad> consultar(String codigoSede, String fechaDesde, String fechaHasta, Boolean soloDisponibles);
    Disponibilidad configurar(SedeServicio sedeServicio, List<HorarioServicio> horarioServicio, String fechaDesde, String fechaHasta, Boolean generarDisponibilidadAutomatica);
    Disponibilidad actualizar(String disponibilidadId, Long capacidadTotal, String estado, String motivoCambio);
    Disponibilidad consultarPorId(String disponibilidadId);
}
