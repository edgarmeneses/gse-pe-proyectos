package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.ExcepcionHoraria;

public interface RegistrarExcepcionHorariaUseCase {
    
    ExcepcionHoraria registrar(ExcepcionHoraria excepcionHoraria);
}
