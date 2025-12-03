package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import pe.gob.reniec.gse.agendamiento.data.domain.model.HorarioServicio;
import java.time.LocalDate;
import java.util.List;

public interface ConfigurarDisponibilidadUseCase {
    
    List<Disponibilidad> configurar(String codigoSede, List<HorarioServicio> horariosServicio,
                                    LocalDate fechaDesde, LocalDate fechaHasta);
}
