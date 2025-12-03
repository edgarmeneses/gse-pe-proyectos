package pe.gob.reniec.agendamiento.msdatos.domain.ports.out;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ConfiguracionDisponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;
import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadRepositoryPort {
    Disponibilidad guardar(Disponibilidad disponibilidad);
    Disponibilidad actualizar(Disponibilidad disponibilidad);
    Disponibilidad buscarPorId(String disponibilidadId);
    List<Disponibilidad> buscarPorSedeYRangoFechas(String codigoSede, LocalDate fechaDesde, 
                                                     LocalDate fechaHasta);
    List<Disponibilidad> buscarDisponibles(String codigoSede, LocalDate fechaDesde, 
                                            LocalDate fechaHasta);
    void guardarConfiguracion(ConfiguracionDisponibilidad configuracion);
    ConfiguracionDisponibilidad buscarConfiguracionPorSede(String codigoSede);
    void eliminar(String disponibilidadId);
}
