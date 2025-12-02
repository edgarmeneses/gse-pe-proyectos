package pe.gob.reniec.padron.paquetes.application.service;

import pe.gob.reniec.padron.paquetes.domain.model.ConfirmacionRevisionResult;
import pe.gob.reniec.padron.paquetes.domain.ports.in.ConfirmarRevisionPaquetesUseCase;
import pe.gob.reniec.padron.paquetes.domain.ports.out.PaqueteDataPort;

public class ConfirmarRevisionPaquetesService implements ConfirmarRevisionPaquetesUseCase {

    private final PaqueteDataPort paqueteDataPort;

    public ConfirmarRevisionPaquetesService(PaqueteDataPort paqueteDataPort) {
        this.paqueteDataPort = paqueteDataPort;
    }

    @Override
    public ConfirmacionRevisionResult confirmarRevision(String idPadron, String tipoPadron,
                                                       String comentarioConfirmacion,
                                                       Boolean confirmarRevisionCompleta) {
        // Validaciones de negocio
        if (idPadron == null || idPadron.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del padrón es obligatorio");
        }
        
        if (tipoPadron == null || tipoPadron.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de padrón es obligatorio");
        }
        
        if (confirmarRevisionCompleta == null || !confirmarRevisionCompleta) {
            throw new IllegalArgumentException("Debe confirmar que la revisión está completa");
        }
        
        // Delega al puerto de salida para confirmar la revisión
        return paqueteDataPort.confirmarRevisionPaquetes(idPadron, tipoPadron, 
                                                         comentarioConfirmacion, confirmarRevisionCompleta);
    }
}
