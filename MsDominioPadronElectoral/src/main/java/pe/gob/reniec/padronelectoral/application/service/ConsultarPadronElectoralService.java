package pe.gob.reniec.padronelectoral.application.service;

import pe.gob.reniec.padronelectoral.domain.model.Ciudadano;
import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.ports.in.ConsultarPadronElectoralUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.out.PadronElectoralDataPort;
import java.util.List;

public class ConsultarPadronElectoralService implements ConsultarPadronElectoralUseCase {
    
    private final PadronElectoralDataPort padronElectoralDataPort;

    public ConsultarPadronElectoralService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public PadronElectoral consultarPorId(String id, Integer page, Integer size) {
        return padronElectoralDataPort.consultarPadronPorId(id, page, size);
    }

    @Override
    public List<Ciudadano> obtenerCiudadanosPaginados(String id, Integer page, Integer size) {
        return padronElectoralDataPort.obtenerCiudadanosPaginados(id, page, size);
    }
}
