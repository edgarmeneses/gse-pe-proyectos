package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.ExcepcionHoraria;

public interface RegistrarExcepcionHorariaUseCase {
    ExcepcionHoraria registrar(ExcepcionHoraria excepcionHoraria);
}
