package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ActualizarDisponibilidadUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.DisponibilidadRepositoryPort;

public class ActualizarDisponibilidadService implements ActualizarDisponibilidadUseCase {
    
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;
    
    public ActualizarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }
    
    @Override
    public Disponibilidad actualizar(String disponibilidadId, Integer capacidadTotal, String estado, String motivoCambio) {
        Disponibilidad disponibilidad = disponibilidadRepositoryPort.buscarPorId(disponibilidadId);
        
        if (capacidadTotal != null) {
            disponibilidad.setCapacidadTotal(capacidadTotal);
            disponibilidad.setCapacidadDisponible(capacidadTotal - disponibilidad.getCapacidadOcupada());
        }
        
        if (estado != null) {
            disponibilidad.setEstado(estado);
        }
        
        return disponibilidadRepositoryPort.actualizar(disponibilidad);
    }
}
