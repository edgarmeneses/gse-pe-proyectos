package pe.gob.reniec.msdatosregistradores.application.service;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;
import pe.gob.reniec.msdatosregistradores.domain.ports.in.ConsultarRegistradorUseCase;
import pe.gob.reniec.msdatosregistradores.domain.ports.out.RegistradorRepositoryPort;

public class ConsultarRegistradorService implements ConsultarRegistradorUseCase {
    private final RegistradorRepositoryPort repositoryPort;

    public ConsultarRegistradorService(RegistradorRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Registrador consultarPorId(String idRegistrador) {
        return repositoryPort.buscarPorId(idRegistrador);
    }
}
