package pe.gob.reniec.msdatosciudadano.application.service;

import pe.gob.reniec.msdatosciudadano.domain.model.CotejoMasivo;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.ConsultaMasivaUseCase;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CotejoMasivoRepositoryPort;

public class ConsultaMasivaService implements ConsultaMasivaUseCase {
    private final CotejoMasivoRepositoryPort repositoryPort;

    public ConsultaMasivaService(CotejoMasivoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public CotejoMasivo procesar(CotejoMasivo cotejoMasivo) {
        return repositoryPort.procesar(cotejoMasivo);
    }
}
