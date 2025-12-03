package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.model.FiltroCita;
import pe.gob.reniec.agendamiento.msdatos.domain.model.Paginacion;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ListarCitasUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.CitaRepositoryPort;
import java.util.List;

public class ListarCitasService implements ListarCitasUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;

    public ListarCitasService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public ResultadoPaginado listar(FiltroCita filtro) {
        List<Cita> citas = citaRepositoryPort.buscarConFiltros(filtro);
        Integer totalRegistros = citaRepositoryPort.contarConFiltros(filtro);
        
        Integer page = filtro.getPage() != null ? filtro.getPage() : 0;
        Integer size = filtro.getSize() != null ? filtro.getSize() : 20;
        Integer totalPaginas = (int) Math.ceil((double) totalRegistros / size);
        
        Paginacion paginacion = new Paginacion(
            totalRegistros,
            totalPaginas,
            page,
            size,
            page > 0,
            page < totalPaginas - 1
        );
        
        return new ResultadoPaginado(citas, paginacion);
    }
}
