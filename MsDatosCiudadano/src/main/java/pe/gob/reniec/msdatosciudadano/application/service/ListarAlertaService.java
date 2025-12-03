package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ListarAlertaUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.AlertaRepositoryPort;
import java.util.List;

public class ListarAlertaService implements ListarAlertaUseCase {
    private final AlertaRepositoryPort repositoryPort;

    public ListarAlertaService(AlertaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Alerta> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields) {
        return repositoryPort.listar(page, size, queryParam1, queryParam2, queryParam3, fields);
    }
}
