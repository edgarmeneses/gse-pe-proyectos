package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.InformePericial;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultarInformePericialUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.InformePericialRepositoryPort;
import java.util.List;

public class ConsultarInformePericialService implements ConsultarInformePericialUseCase {
    private final InformePericialRepositoryPort repositoryPort;

    public ConsultarInformePericialService(InformePericialRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<InformePericial> consultar(String tipoDocumento, String numeroDocumento) {
        return repositoryPort.buscarPorDocumento(tipoDocumento, numeroDocumento);
    }
}
