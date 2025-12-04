package pe.gob.onpe.dominio.tachareclamo.application.service;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Derivacion;
import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.DerivarTachaReclamoUseCase;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.out.TachaReclamoDataPort;

import java.time.LocalDateTime;

public class DerivarTachaReclamoService implements DerivarTachaReclamoUseCase {
    private final TachaReclamoDataPort tachaReclamoDataPort;

    public DerivarTachaReclamoService(TachaReclamoDataPort tachaReclamoDataPort) {
        this.tachaReclamoDataPort = tachaReclamoDataPort;
    }

    @Override
    public Derivacion derivar(Long tachaReclamoId, String areaDestino, String responsable, String observaciones) {
        // Obtener la tacha/reclamo
        TachaReclamo tachaReclamo = tachaReclamoDataPort.obtenerPorId(tachaReclamoId);
        if (tachaReclamo == null) {
            throw new IllegalArgumentException("Tacha/Reclamo no encontrado");
        }

        // Validar que esté en estado VALIDADO
        if (!"VALIDADO".equals(tachaReclamo.getEstado())) {
            throw new IllegalStateException("Solo se pueden derivar tachas/reclamos validadas");
        }

        // Validar área destino
        if (areaDestino == null || areaDestino.trim().isEmpty()) {
            throw new IllegalArgumentException("Área destino es obligatoria");
        }

        // Validar responsable
        if (responsable == null || responsable.trim().isEmpty()) {
            throw new IllegalArgumentException("Responsable es obligatorio");
        }

        // Crear derivación
        Derivacion derivacion = new Derivacion();
        derivacion.setTachaReclamoId(tachaReclamoId);
        derivacion.setAreaOrigen(tachaReclamo.getAreaActual());
        derivacion.setAreaDestino(areaDestino);
        derivacion.setResponsable(responsable);
        derivacion.setObservaciones(observaciones);
        derivacion.setFechaDerivacion(LocalDateTime.now());

        // Actualizar tacha/reclamo
        tachaReclamo.setEstado("DERIVADO");
        tachaReclamo.setAreaActual(areaDestino);
        tachaReclamo.setResponsableActual(responsable);
        tachaReclamoDataPort.actualizar(tachaReclamoId, tachaReclamo);

        return derivacion;
    }
}
