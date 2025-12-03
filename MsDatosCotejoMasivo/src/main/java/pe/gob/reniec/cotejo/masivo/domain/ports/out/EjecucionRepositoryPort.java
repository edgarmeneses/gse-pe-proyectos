package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase.FiltrosEjecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase.Paginacion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase.ResultadoPaginado;

public interface EjecucionRepositoryPort {
    Ejecucion crear(Ejecucion ejecucion);
    Ejecucion consultarPorId(String ejecucionId);
    ResultadoPaginado listar(FiltrosEjecucion filtros, Paginacion paginacion);
    void actualizar(Ejecucion ejecucion);
}
