package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.CancelarCitaUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.CitaRepositoryPort;

public class CancelarCitaService implements CancelarCitaUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;

    public CancelarCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public ResultadoCancelacion cancelar(String citaId, String tokenReagendamiento, 
                                          String motivoCancelacion, String observaciones) {
        Cita cita = citaRepositoryPort.buscarPorId(citaId);
        if (cita == null) {
            throw new RuntimeException("Cita no encontrada");
        }
        
        String estadoAnterior = cita.getEstado().getCodigo();
        cita.getEstado().setCodigo("CANCELADA");
        citaRepositoryPort.actualizar(cita);
        
        return new ResultadoCancelacion(
            citaId,
            cita.getCodigoCita(),
            estadoAnterior,
            "CANCELADA",
            motivoCancelacion,
            true
        );
    }
}
