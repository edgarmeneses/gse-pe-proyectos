package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.ports.in.ConsultarSolicitudesPendientesOfflineUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;
import java.util.List;

public class ConsultarSolicitudesPendientesOfflineService implements ConsultarSolicitudesPendientesOfflineUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;

    public ConsultarSolicitudesPendientesOfflineService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }

    @Override
    public List<Solicitud> ejecutar(String oficinaCode, String dispositivoId, String fechaDesde, String fechaHasta,
                                     String estadoSincronizacion, Long page, Long size, Boolean incluirDetalles) {
        return solicitudRepositoryPort.buscarPendientesOffline(oficinaCode, dispositivoId, fechaDesde, fechaHasta,
                estadoSincronizacion, page, size, incluirDetalles);
    }
}
