package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.CrearCiudadanoUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CiudadanoRepositoryPort;

public class CrearCiudadanoService implements CrearCiudadanoUseCase {
    private final CiudadanoRepositoryPort repositoryPort;

    public CrearCiudadanoService(CiudadanoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public String crear(Ciudadano ciudadano) {
        return repositoryPort.guardar(ciudadano);
    }
}
