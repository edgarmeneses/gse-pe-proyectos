package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultarAlertaUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.AlertaRepositoryPort;

public class ConsultarAlertaService implements ConsultarAlertaUseCase {
    private final AlertaRepositoryPort repositoryPort;

    public ConsultarAlertaService(AlertaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Alerta consultar(String alertaId) {
        return repositoryPort.buscarPorId(alertaId);
    }
}
