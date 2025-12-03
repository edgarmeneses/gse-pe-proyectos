package pe.gob.reniec.gse.agendamiento.data.domain.ports.out;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadRepositoryPort {
    
    Disponibilidad guardar(Disponibilidad disponibilidad);
    
    Disponibilidad actualizar(Disponibilidad disponibilidad);
    
    Disponibilidad buscarPorId(String idDisponibilidad);
    
    List<Disponibilidad> buscarPorSedeYFecha(String codigoSede, LocalDate fechaDesde, LocalDate fechaHasta, Boolean soloDisponibles);
    
    List<Disponibilidad> guardarLote(List<Disponibilidad> disponibilidades);
}
