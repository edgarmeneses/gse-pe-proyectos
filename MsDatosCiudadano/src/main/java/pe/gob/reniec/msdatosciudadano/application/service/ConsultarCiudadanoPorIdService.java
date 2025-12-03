package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultarCiudadanoPorIdUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CiudadanoRepositoryPort;

public class ConsultarCiudadanoPorIdService implements ConsultarCiudadanoPorIdUseCase {

    private final CiudadanoRepositoryPort ciudadanoRepositoryPort;

    public ConsultarCiudadanoPorIdService(CiudadanoRepositoryPort ciudadanoRepositoryPort) {
        this.ciudadanoRepositoryPort = ciudadanoRepositoryPort;
    }

    @Override
    public Ciudadano consultarPorId(String ciudadanoId) {
        return ciudadanoRepositoryPort.buscarPorId(ciudadanoId);
    }
}

