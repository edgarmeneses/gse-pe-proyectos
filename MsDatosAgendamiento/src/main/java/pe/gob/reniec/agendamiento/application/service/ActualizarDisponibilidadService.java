package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.domain.ports.in.ActualizarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.DisponibilidadRepositoryPort;

public class ActualizarDisponibilidadService implements ActualizarDisponibilidadUseCase {
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;

    public ActualizarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }

    @Override
    public Disponibilidad actualizar(String disponibilidadId, Long capacidadTotal, String estado, String motivoCambio) {
        return disponibilidadRepositoryPort.actualizar(disponibilidadId, capacidadTotal, estado, motivoCambio);
    }
}
