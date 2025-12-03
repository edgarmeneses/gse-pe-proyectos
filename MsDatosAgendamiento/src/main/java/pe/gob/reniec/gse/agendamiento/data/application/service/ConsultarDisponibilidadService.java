package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import pe.gob.reniec.gse.agendamiento.data.domain.model.ResumenDisponibilidad;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ConsultarDisponibilidadUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.DisponibilidadRepositoryPort;
import java.time.LocalDate;
import java.util.List;

public class ConsultarDisponibilidadService implements ConsultarDisponibilidadUseCase {
    
    private final DisponibilidadRepositoryPort disponibilidadRepositoryPort;
    
    public ConsultarDisponibilidadService(DisponibilidadRepositoryPort disponibilidadRepositoryPort) {
        this.disponibilidadRepositoryPort = disponibilidadRepositoryPort;
    }
    
    @Override
    public List<Disponibilidad> consultar(String codigoSede, LocalDate fechaDesde, LocalDate fechaHasta, Boolean soloDisponibles) {
        return disponibilidadRepositoryPort.listar(codigoSede, fechaDesde, fechaHasta, soloDisponibles);
    }
    
    @Override
    public ResumenDisponibilidad obtenerResumen(String codigoSede, LocalDate fechaDesde, LocalDate fechaHasta) {
        List<Disponibilidad> disponibilidades = disponibilidadRepositoryPort.listar(codigoSede, fechaDesde, fechaHasta, false);
        
        // Calcular resumen
        Integer totalDias = disponibilidades.size();
        Integer diasHabiles = (int) disponibilidades.stream().filter(Disponibilidad::getEsHabil).count();
        Integer diasNoHabiles = totalDias - diasHabiles;
        Integer totalFranjas = disponibilidades.size();
        Integer franjasDisponibles = (int) disponibilidades.stream()
            .filter(d -> d.getCapacidadDisponible() > 0).count();
        Integer franjasOcupadas = totalFranjas - franjasDisponibles;
        
        return new ResumenDisponibilidad(totalDias, diasHabiles, diasNoHabiles, 
                                        totalFranjas, franjasDisponibles, franjasOcupadas);
    }
}
