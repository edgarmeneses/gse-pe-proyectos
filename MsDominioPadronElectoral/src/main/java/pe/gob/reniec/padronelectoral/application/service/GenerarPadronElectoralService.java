package pe.gob.reniec.padronelectoral.application.service;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.ports.in.GenerarPadronElectoralUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.out.PadronElectoralDataPort;

public class GenerarPadronElectoralService implements GenerarPadronElectoralUseCase {
    
    private final PadronElectoralDataPort padronElectoralDataPort;

    public GenerarPadronElectoralService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public PadronElectoral generar(String tipoPadron, String departamento, String provincia, String distrito) {
        return padronElectoralDataPort.crearPadron(tipoPadron, departamento, provincia, distrito);
    }
}
