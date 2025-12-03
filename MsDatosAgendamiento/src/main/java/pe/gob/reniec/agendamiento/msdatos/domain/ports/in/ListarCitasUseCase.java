package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.application.query.FiltroBusquedaCita;
import pe.gob.reniec.agendamiento.msdatos.application.query.ResultadoPaginado;
import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import java.util.List;

public interface ListarCitasUseCase {
    
    ResultadoPaginado listar(FiltroBusquedaCita filtro);
    
    // Record interno para el resultado
    record ResultadoPaginado(List<Cita> citas, ResultadoPaginado paginacion) {
    }
}
