package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ActualizarCiudadanoUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CiudadanoRepositoryPort;
import java.util.List;

public class ActualizarCiudadanoService implements ActualizarCiudadanoUseCase {
    private final CiudadanoRepositoryPort repositoryPort;

    public ActualizarCiudadanoService(CiudadanoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<String> actualizar(String id, Ciudadano ciudadano) {
        repositoryPort.actualizar(id, ciudadano);
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
