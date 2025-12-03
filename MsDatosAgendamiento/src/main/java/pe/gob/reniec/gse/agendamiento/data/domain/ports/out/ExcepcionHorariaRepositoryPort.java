package pe.gob.reniec.gse.agendamiento.data.domain.ports.out;

import pe.gob.reniec.gse.agendamiento.data.domain.model.ExcepcionHoraria;
import java.time.LocalDate;
import java.util.List;

public interface ExcepcionHorariaRepositoryPort {
    
    ExcepcionHoraria guardar(ExcepcionHoraria excepcionHoraria);
    
    List<ExcepcionHoraria> buscarPorSedeYFecha(String codigoSede, LocalDate fecha);
}
