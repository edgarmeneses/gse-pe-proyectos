package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.InformeFinal;
import pe.gob.onpe.datos.electoral.domain.ports.in.GuardarInformeFinalUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.InformeFinalRepositoryPort;

public class GuardarInformeFinalService implements GuardarInformeFinalUseCase {
    private final InformeFinalRepositoryPort informeFinalRepositoryPort;

    public GuardarInformeFinalService(InformeFinalRepositoryPort informeFinalRepositoryPort) {
        this.informeFinalRepositoryPort = informeFinalRepositoryPort;
    }

    @Override
    public InformeFinal guardar(InformeFinal informeFinal) {
        return informeFinalRepositoryPort.save(informeFinal);
    }
}
