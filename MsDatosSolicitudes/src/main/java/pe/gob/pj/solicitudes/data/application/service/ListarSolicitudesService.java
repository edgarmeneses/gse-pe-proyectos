package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.ports.in.ListarSolicitudesUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;
import java.util.List;

public class ListarSolicitudesService implements ListarSolicitudesUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;
    
    public ListarSolicitudesService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }
    
    @Override
    public List<Solicitud> listar() {
        return solicitudRepositoryPort.listar();
    }
}
