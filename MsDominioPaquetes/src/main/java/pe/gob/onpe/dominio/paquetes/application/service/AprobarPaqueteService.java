package pe.gob.onpe.dominio.paquetes.application.service;

import pe.gob.onpe.dominio.paquetes.domain.model.Aprobacion;
import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import pe.gob.onpe.dominio.paquetes.domain.ports.in.AprobarPaqueteUseCase;
import pe.gob.onpe.dominio.paquetes.domain.ports.out.PadronElectoralDataPort;
import java.time.LocalDateTime;

public class AprobarPaqueteService implements AprobarPaqueteUseCase {
    private final PadronElectoralDataPort padronElectoralDataPort;

    public AprobarPaqueteService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public PaqueteElectoral aprobar(String paqueteId, LocalDateTime fechaPublicacion, String lugarPublicacion,
                                    String observaciones, String comentarioAprobacion, Boolean confirmarIntegridad) {
        if (confirmarIntegridad == null || !confirmarIntegridad) {
            throw new UnsupportedOperationException("La confirmación de integridad es obligatoria");
        }

        PaqueteElectoral paquete = padronElectoralDataPort.consultarPaqueteElectoral(paqueteId);
        if (paquete == null) {
            throw new UnsupportedOperationException("Paquete no encontrado");
        }

        padronElectoralDataPort.actualizarPaqueteElectoral(paqueteId, "APROBADO");

        Aprobacion aprobacion = new Aprobacion();
        aprobacion.setAprobado(true);
        aprobacion.setFechaAprobacion(LocalDateTime.now());
        aprobacion.setComentarioAprobacion(comentarioAprobacion);
        
        paquete.setAprobacion(aprobacion);
        paquete.setEstadoPaquete("APROBADO");

        padronElectoralDataPort.registrarTrazabilidad(paqueteId, "APROBACION_PAQUETE",
                aprobacion.getUsuarioAprobacion(), null, "Paquete aprobado exitosamente");

        return paquete;
    }
}
