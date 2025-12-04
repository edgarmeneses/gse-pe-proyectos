package pe.gob.onpe.dominio.paquetes.domain.ports.in;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import java.time.LocalDateTime;

public interface AprobarPaqueteUseCase {
    PaqueteElectoral aprobar(String paqueteId, LocalDateTime fechaPublicacion, String lugarPublicacion,
                             String observaciones, String comentarioAprobacion, Boolean confirmarIntegridad);
}
