package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.ports.in.CrearSolicitudUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;

public class CrearSolicitudService implements CrearSolicitudUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;
    
    public CrearSolicitudService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }
    
    @Override
    public Solicitud crear(Solicitud solicitud) {
        return solicitudRepositoryPort.guardar(solicitud);
    }
}
