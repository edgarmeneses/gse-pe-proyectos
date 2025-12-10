package pe.gob.reniec.padronelectoral.application.service;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.ports.in.ActualizarPadronElectoralUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.out.PadronElectoralDataPort;

public class ActualizarPadronElectoralService implements ActualizarPadronElectoralUseCase {
    
    private final PadronElectoralDataPort padronElectoralDataPort;

    public ActualizarPadronElectoralService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public PadronElectoral actualizar(String id, String usuarioResponsableId, String tipoPadron, 
                                     String informeFinalVerificacionDomicilioId, String tipoVerificacion) {
        return padronElectoralDataPort.actualizarPadron(id, usuarioResponsableId, tipoPadron, 
                                                       informeFinalVerificacionDomicilioId, tipoVerificacion);
    }
}
