package pe.gob.reniec.padron.paquetes.domain.ports.in;

import pe.gob.reniec.padron.paquetes.domain.model.ConfirmacionRevisionResult;

public interface ConfirmarRevisionPaquetesUseCase {
    
    ConfirmacionRevisionResult confirmarRevision(String idPadron, String tipoPadron,
                                                 String comentarioConfirmacion, 
                                                 Boolean confirmarRevisionCompleta);
}
