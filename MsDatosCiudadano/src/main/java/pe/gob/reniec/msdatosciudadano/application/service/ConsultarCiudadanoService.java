package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultarCiudadanoUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CiudadanoRepositoryPort;

public class ConsultarCiudadanoService implements ConsultarCiudadanoUseCase {
    private final CiudadanoRepositoryPort repositoryPort;

    public ConsultarCiudadanoService(CiudadanoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Ciudadano consultar(String tipoDocumento, String numeroDocumento) {
        return repositoryPort.buscarPorDocumento(tipoDocumento, numeroDocumento);
    }
}
