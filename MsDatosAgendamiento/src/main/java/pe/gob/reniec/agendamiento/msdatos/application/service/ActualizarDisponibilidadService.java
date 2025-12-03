package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ActualizarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.DisponibilidadRepositoryPort;

public class ActualizarDisponibilidadService implements ActualizarDisponibilidadUseCase {
    
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;

    public ActualizarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }

    @Override
    public Disponibilidad actualizar(String disponibilidadId, Integer capacidadTotal, 
                                      String estado, String motivoCambio) {
        Disponibilidad disponibilidad = disponibilidadRepositoryPort.buscarPorId(disponibilidadId);
        if (disponibilidad == null) {
            throw new RuntimeException("Disponibilidad no encontrada");
        }
        
        if (capacidadTotal != null) {
            disponibilidad.setCapacidadTotal(capacidadTotal);
        }
        if (estado != null) {
            disponibilidad.setEstado(estado);
        }
        
        return disponibilidadRepositoryPort.actualizar(disponibilidad);
    }
}
