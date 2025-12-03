package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.ports.in.ActualizarSolicitudUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;

public class ActualizarSolicitudService implements ActualizarSolicitudUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;

    public ActualizarSolicitudService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }

    @Override
    public Solicitud ejecutar(String solicitudId, Solicitud solicitud) {
        return solicitudRepositoryPort.actualizar(solicitudId, solicitud);
    }
}
