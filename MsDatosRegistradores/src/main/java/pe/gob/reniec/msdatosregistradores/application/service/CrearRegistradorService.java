package pe.gob.reniec.msdatosregistradores.application.service;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;
import pe.gob.reniec.msdatosregistradores.domain.ports.in.CrearRegistradorUseCase;
import pe.gob.reniec.msdatosregistradores.domain.ports.out.RegistradorRepositoryPort;

public class CrearRegistradorService implements CrearRegistradorUseCase {
    private final RegistradorRepositoryPort repositoryPort;

    public CrearRegistradorService(RegistradorRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Registrador crear(Registrador registrador) {
        return repositoryPort.guardar(registrador);
    }
}
