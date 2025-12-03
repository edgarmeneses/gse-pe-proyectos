package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ExcepcionHoraria;
import java.util.List;

public interface RegistrarExcepcionHorariaUseCase {
    
    ResultadoRegistro registrar(ExcepcionHoraria excepcion);
    
    record ResultadoRegistro(
        ExcepcionHoraria excepcion,
        List<String> citasAfectadas
    ) {}
}
