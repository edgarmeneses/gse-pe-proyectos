package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.domain.ports.in.VerificarDuplicadosUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;

public class VerificarDuplicadosService implements VerificarDuplicadosUseCase {
    
    private final SolicitudRepositoryPort solicitudRepositoryPort;

    public VerificarDuplicadosService(SolicitudRepositoryPort solicitudRepositoryPort) {
        this.solicitudRepositoryPort = solicitudRepositoryPort;
    }

    @Override
    public Boolean ejecutar(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento,
                            String usuarioId, Long limit, Long offset, String ordenamiento,
                            Boolean incluirDatosDetallados) {
        return solicitudRepositoryPort.verificarDuplicados(solicitudId, fechaDesde, fechaHasta, tipoEvento,
                usuarioId, limit, offset, ordenamiento, incluirDatosDetallados);
    }
}
