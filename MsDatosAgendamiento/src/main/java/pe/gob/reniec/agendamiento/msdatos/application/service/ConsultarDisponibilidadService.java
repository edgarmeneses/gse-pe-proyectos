package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ConsultarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.DisponibilidadRepositoryPort;
import java.time.LocalDate;
import java.util.List;

public class ConsultarDisponibilidadService implements ConsultarDisponibilidadUseCase {
    
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;

    public ConsultarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }

    @Override
    public ResultadoDisponibilidad consultar(String codigoSede, LocalDate fechaDesde, 
                                              LocalDate fechaHasta, Boolean soloDisponibles) {
        List<Disponibilidad> disponibilidades;
        
        if (Boolean.TRUE.equals(soloDisponibles)) {
            disponibilidades = disponibilidadRepositoryPort.buscarDisponibles(codigoSede, 
                fechaDesde, fechaHasta);
        } else {
            disponibilidades = disponibilidadRepositoryPort.buscarPorSedeYRangoFechas(codigoSede, 
                fechaDesde, fechaHasta);
        }
        
        throw new UnsupportedOperationException("Método pendiente de implementación completa");
    }
}
