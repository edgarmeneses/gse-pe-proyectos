package pe.gob.reniec.padron.paquetes.application.service;

import pe.gob.reniec.padron.paquetes.domain.model.AprobacionResult;
import pe.gob.reniec.padron.paquetes.domain.model.InformacionPublicacion;
import pe.gob.reniec.padron.paquetes.domain.ports.in.AprobarPaqueteUseCase;
import pe.gob.reniec.padron.paquetes.domain.ports.out.PaqueteDataPort;

public class AprobarPaqueteService implements AprobarPaqueteUseCase {

    private final PaqueteDataPort paqueteDataPort;

    public AprobarPaqueteService(PaqueteDataPort paqueteDataPort) {
        this.paqueteDataPort = paqueteDataPort;
    }

    @Override
    public AprobacionResult aprobar(String paqueteId, InformacionPublicacion informacionPublicacion,
                                    String comentarioAprobacion, Boolean confirmarIntegridad) {
        // Validaciones de negocio
        if (paqueteId == null || paqueteId.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del paquete es obligatorio");
        }
        
        if (confirmarIntegridad == null || !confirmarIntegridad) {
            throw new IllegalArgumentException("Debe confirmar la integridad del paquete");
        }
        
        // Delega al puerto de salida para realizar la aprobación
        return paqueteDataPort.aprobarPaquete(paqueteId, informacionPublicacion, 
                                              comentarioAprobacion, confirmarIntegridad);
    }
}
