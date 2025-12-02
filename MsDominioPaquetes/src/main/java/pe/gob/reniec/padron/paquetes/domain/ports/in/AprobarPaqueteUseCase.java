package pe.gob.reniec.padron.paquetes.domain.ports.in;

import pe.gob.reniec.padron.paquetes.domain.model.AprobacionResult;
import pe.gob.reniec.padron.paquetes.domain.model.InformacionPublicacion;

public interface AprobarPaqueteUseCase {
    
    AprobacionResult aprobar(String paqueteId, InformacionPublicacion informacionPublicacion,
                            String comentarioAprobacion, Boolean confirmarIntegridad);
}
