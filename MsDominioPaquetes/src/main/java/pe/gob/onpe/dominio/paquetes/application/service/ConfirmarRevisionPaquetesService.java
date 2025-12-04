package pe.gob.onpe.dominio.paquetes.application.service;

import pe.gob.onpe.dominio.paquetes.domain.ports.in.ConfirmarRevisionPaquetesUseCase;
import pe.gob.onpe.dominio.paquetes.domain.ports.out.PadronElectoralDataPort;

public class ConfirmarRevisionPaquetesService implements ConfirmarRevisionPaquetesUseCase {
    private final PadronElectoralDataPort padronElectoralDataPort;

    public ConfirmarRevisionPaquetesService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public void confirmarRevision(String idPadron, String tipoPadron,
                                  String comentarioConfirmacion, Boolean confirmarRevisionCompleta) {
        if (confirmarRevisionCompleta == null || !confirmarRevisionCompleta) {
            throw new UnsupportedOperationException("La confirmación de revisión completa es obligatoria");
        }

        Integer totalPaquetes = padronElectoralDataPort.contarPaquetesPorPadron(idPadron);
        Integer paquetesAprobados = padronElectoralDataPort.contarPaquetesAprobadosPorPadron(idPadron);
        
        if (!totalPaquetes.equals(paquetesAprobados)) {
            throw new UnsupportedOperationException("No todos los paquetes están aprobados");
        }

        padronElectoralDataPort.actualizarEstadoRevision(idPadron, "REVISION_CONFIRMADA");
    }
}
