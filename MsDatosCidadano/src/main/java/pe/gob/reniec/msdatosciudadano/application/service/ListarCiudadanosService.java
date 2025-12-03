package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ListarCiudadanosUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CiudadanoRepositoryPort;
import java.util.List;

public class ListarCiudadanosService implements ListarCiudadanosUseCase {
    private final CiudadanoRepositoryPort repositoryPort;

    public ListarCiudadanosService(CiudadanoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Ciudadano> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields) {
        return repositoryPort.listar(page, size, queryParam1, queryParam2, queryParam3, fields);
    }
}
