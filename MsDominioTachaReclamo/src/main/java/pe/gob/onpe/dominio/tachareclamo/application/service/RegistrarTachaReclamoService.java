package pe.gob.onpe.dominio.tachareclamo.application.service;

import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.RegistrarTachaReclamoUseCase;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.out.TachaReclamoDataPort;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistrarTachaReclamoService implements RegistrarTachaReclamoUseCase {
    private final TachaReclamoDataPort tachaReclamoDataPort;

    public RegistrarTachaReclamoService(TachaReclamoDataPort tachaReclamoDataPort) {
        this.tachaReclamoDataPort = tachaReclamoDataPort;
    }

    @Override
    public TachaReclamo registrar(TachaReclamo tachaReclamo) {
        // Validar tipo (TACHA o RECLAMO)
        if (tachaReclamo.getTipo() == null || 
            (!tachaReclamo.getTipo().equals("TACHA") && !tachaReclamo.getTipo().equals("RECLAMO"))) {
            throw new IllegalArgumentException("Tipo debe ser TACHA o RECLAMO");
        }

        // Validar sustento y descripción obligatorios
        if (tachaReclamo.getSustento() == null || tachaReclamo.getSustento().trim().isEmpty()) {
            throw new IllegalArgumentException("Sustento es obligatorio");
        }
        if (tachaReclamo.getDescripcion() == null || tachaReclamo.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("Descripción es obligatoria");
        }

        // Generar número de expediente automático
        String numeroExpediente = "EXP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        tachaReclamo.setNumeroExpediente(numeroExpediente);

        // Establecer estado inicial
        tachaReclamo.setEstado("REGISTRADO");
        tachaReclamo.setFechaRegistro(LocalDateTime.now());

        // Persistir a través del puerto de salida (MsDatosElectoral)
        return tachaReclamoDataPort.crear(tachaReclamo);
    }
}
