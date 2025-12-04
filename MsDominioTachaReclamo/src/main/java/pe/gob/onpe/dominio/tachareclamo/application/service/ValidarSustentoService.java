package pe.gob.onpe.dominio.tachareclamo.application.service;

import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;
import pe.gob.onpe.dominio.tachareclamo.domain.model.ValidacionSustento;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.ValidarSustentoUseCase;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.out.TachaReclamoDataPort;

import java.time.LocalDateTime;

public class ValidarSustentoService implements ValidarSustentoUseCase {
    private final TachaReclamoDataPort tachaReclamoDataPort;

    public ValidarSustentoService(TachaReclamoDataPort tachaReclamoDataPort) {
        this.tachaReclamoDataPort = tachaReclamoDataPort;
    }

    @Override
    public ValidacionSustento validar(Long tachaReclamoId, String sustento, String observaciones) {
        // Obtener la tacha/reclamo
        TachaReclamo tachaReclamo = tachaReclamoDataPort.obtenerPorId(tachaReclamoId);
        if (tachaReclamo == null) {
            throw new IllegalArgumentException("Tacha/Reclamo no encontrado");
        }

        // Validar que esté en estado REGISTRADO
        if (!"REGISTRADO".equals(tachaReclamo.getEstado())) {
            throw new IllegalStateException("Solo se pueden validar tachas/reclamos en estado REGISTRADO");
        }

        // Validar observaciones obligatorias
        if (observaciones == null || observaciones.trim().isEmpty()) {
            throw new IllegalArgumentException("Observaciones son obligatorias");
        }

        // Determinar si es válido (simplificado: si el sustento tiene más de 50 caracteres)
        Boolean esValido = sustento != null && sustento.length() > 50;

        // Actualizar estado según validación
        String nuevoEstado = esValido ? "VALIDADO" : "RECHAZADO";
        tachaReclamo.setEstado(nuevoEstado);
        tachaReclamoDataPort.actualizar(tachaReclamoId, tachaReclamo);

        // Crear y retornar validación
        ValidacionSustento validacion = new ValidacionSustento();
        validacion.setTachaReclamoId(tachaReclamoId);
        validacion.setEsValido(esValido);
        validacion.setObservaciones(observaciones);
        validacion.setFechaValidacion(LocalDateTime.now());
        validacion.setValidadoPor("SISTEMA");

        return validacion;
    }
}
