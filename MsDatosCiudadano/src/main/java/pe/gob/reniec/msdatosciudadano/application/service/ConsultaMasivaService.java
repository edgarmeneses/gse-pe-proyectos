package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.ConsultaMasiva;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultaMasivaUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.ConsultaMasivaRepositoryPort;

public class ConsultaMasivaService implements ConsultaMasivaUseCase {
    private final ConsultaMasivaRepositoryPort repositoryPort;

    public ConsultaMasivaService(ConsultaMasivaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ConsultaMasiva procesar(ConsultaMasiva consultaMasiva) {
        return repositoryPort.procesar(consultaMasiva);
    }
}
