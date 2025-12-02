package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.domain.model.SedeServicio;
import pe.gob.reniec.agendamiento.domain.model.HorarioServicio;
import pe.gob.reniec.agendamiento.domain.ports.in.ConfigurarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.DisponibilidadRepositoryPort;
import java.util.List;

public class ConfigurarDisponibilidadService implements ConfigurarDisponibilidadUseCase {
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;

    public ConfigurarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }

    @Override
    public Disponibilidad configurar(SedeServicio sedeServicio, List<HorarioServicio> horarioServicio, String fechaDesde, String fechaHasta, Boolean generarDisponibilidadAutomatica) {
        return disponibilidadRepositoryPort.configurar(sedeServicio, horarioServicio, fechaDesde, fechaHasta, generarDisponibilidadAutomatica);
    }
}
