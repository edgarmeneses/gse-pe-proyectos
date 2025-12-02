package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.RegistrarRegistrosEntradaUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.RegistroEntradaRepositoryPort;
import java.util.List;
import java.util.UUID;

public class RegistrarRegistrosEntradaService implements RegistrarRegistrosEntradaUseCase {
    private final RegistroEntradaRepositoryPort registroEntradaRepositoryPort;

    public RegistrarRegistrosEntradaService(RegistroEntradaRepositoryPort registroEntradaRepositoryPort) {
        this.registroEntradaRepositoryPort = registroEntradaRepositoryPort;
    }

    @Override
    public List<RegistroEntrada> registrar(UUID ejecucionId, List<RegistroEntrada> registros) {
        return registroEntradaRepositoryPort.guardarLote(registros);
    }
}
