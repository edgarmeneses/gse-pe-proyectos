package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;

public class ListarEjecucionesService implements ListarEjecucionesUseCase {
    private final EjecucionRepositoryPort ejecucionRepositoryPort;

    public ListarEjecucionesService(EjecucionRepositoryPort ejecucionRepositoryPort) {
        this.ejecucionRepositoryPort = ejecucionRepositoryPort;
    }

    @Override
    public ResultadoPaginado listar(FiltrosEjecucion filtros, Paginacion paginacion) {
        return ejecucionRepositoryPort.listar(filtros, paginacion);
    }
}
