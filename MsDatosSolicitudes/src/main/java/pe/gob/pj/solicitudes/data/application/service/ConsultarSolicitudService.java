package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.ports.in.ConsultarSolicitudUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;

public class ConsultarSolicitudService implements ConsultarSolicitudUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;
    
    public ConsultarSolicitudService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }
    
    @Override
    public Solicitud consultar(Long id) {
        return solicitudRepositoryPort.buscarPorId(id);
    }
}
