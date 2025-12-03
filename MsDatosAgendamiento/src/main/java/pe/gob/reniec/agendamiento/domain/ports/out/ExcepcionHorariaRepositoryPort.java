package pe.gob.reniec.agendamiento.domain.ports.out;

import pe.gob.reniec.agendamiento.domain.model.ExcepcionHoraria;

public interface ExcepcionHorariaRepositoryPort {
    ExcepcionHoraria guardar(ExcepcionHoraria excepcionHoraria);
    ExcepcionHoraria consultarPorId(String idExcepcion);
}
