package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.application.query.SolicitudQueryResult;
import pe.gob.pj.solicitudes.data.domain.ports.in.ListarSolicitudesUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;

public class ListarSolicitudesService implements ListarSolicitudesUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;

    public ListarSolicitudesService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }

    @Override
    public SolicitudQueryResult ejecutar(String estado, String tipoTramite, String codigoOficina, String dniSolicitante,
                                          String usuarioAsignado, String fechaDesde, String fechaHasta, String prioridad,
                                          Boolean soloVencidas, Long page, Long size, String sort, String direction) {
        return solicitudRepositoryPort.listar(estado, tipoTramite, codigoOficina, dniSolicitante, usuarioAsignado,
                fechaDesde, fechaHasta, prioridad, soloVencidas, page, size, sort, direction);
    }
}
