package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ConfiguracionDisponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ConfigurarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.DisponibilidadRepositoryPort;

public class ConfigurarDisponibilidadService implements ConfigurarDisponibilidadUseCase {
    
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;

    public ConfigurarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }

    @Override
    public ResultadoConfiguracion configurar(ConfiguracionDisponibilidad configuracion, 
                                              Boolean generarDisponibilidadAutomatica) {
        disponibilidadRepositoryPort.guardarConfiguracion(configuracion);
        throw new UnsupportedOperationException("Método pendiente de implementación completa");
    }
}
