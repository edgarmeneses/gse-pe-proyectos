package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.domain.ports.in.ConsultarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.DisponibilidadRepositoryPort;
import java.util.List;

public class ConsultarDisponibilidadService implements ConsultarDisponibilidadUseCase {
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;

    public ConsultarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }

    @Override
    public List<Disponibilidad> consultar(String codigoSede, String fechaDesde, String fechaHasta, Boolean soloDisponibles) {
        return disponibilidadRepositoryPort.consultar(codigoSede, fechaDesde, fechaHasta, soloDisponibles);
    }
}
