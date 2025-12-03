package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.HorarioServicio;
import pe.gob.reniec.gse.agendamiento.data.domain.model.SedeServicio;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ConfigurarDisponibilidadUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.DisponibilidadRepositoryPort;
import java.time.LocalDate;
import java.util.List;

public class ConfigurarDisponibilidadService implements ConfigurarDisponibilidadUseCase {
    
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;
    
    public ConfigurarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }
    
    @Override
    public void configurar(SedeServicio sedeServicio, List<HorarioServicio> horarioServicio,
                          LocalDate fechaDesde, LocalDate fechaHasta, Boolean generarDisponibilidadAutomatica) {
        // Lógica de configuración y generación automática de disponibilidad
        throw new UnsupportedOperationException("Configuración de disponibilidad no implementada");
    }
}
