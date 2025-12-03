package pe.gob.reniec.agendamiento.msdatos.domain.ports.out;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ExcepcionHoraria;
import java.time.LocalDate;
import java.util.List;

public interface ExcepcionHorariaRepositoryPort {
    ExcepcionHoraria guardar(ExcepcionHoraria excepcion);
    ExcepcionHoraria buscarPorId(String idExcepcion);
    List<ExcepcionHoraria> buscarPorSedeYFecha(String codigoSede, LocalDate fecha);
    List<ExcepcionHoraria> buscarPorSede(String codigoSede);
    Boolean existeExcepcionEnFecha(String codigoSede, LocalDate fecha);
    void eliminar(String idExcepcion);
}
