package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.CrearAlertaUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.AlertaRepositoryPort;

public class CrearAlertaService implements CrearAlertaUseCase {
    private final AlertaRepositoryPort repositoryPort;

    public CrearAlertaService(AlertaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public String crear(Alerta alerta) {
        return repositoryPort.guardar(alerta);
    }
}
