package pe.gob.reniec.padronelectoral.domain.ports.in;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;

public interface ActualizarPadronElectoralUseCase {
    PadronElectoral actualizar(String id, String usuarioResponsableId, String tipoPadron, 
                              String informeFinalVerificacionDomicilioId, String tipoVerificacion);
}
