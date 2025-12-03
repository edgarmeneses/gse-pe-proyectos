package pe.gob.pj.solicitudes.data.application.service;

import pe.gob.pj.solicitudes.data.application.query.TrazabilidadQueryResult;
import pe.gob.pj.solicitudes.data.domain.ports.in.VerTrazabilidadUseCase;
import pe.gob.pj.solicitudes.data.domain.ports.out.TrazabilidadRepositoryPort;

public class VerTrazabilidadService implements VerTrazabilidadUseCase {
    
    private final TrazabilidadRepositoryPort trazabilidadRepositoryPort;

    public VerTrazabilidadService(TrazabilidadRepositoryPort trazabilidadRepositoryPort) {
        this.trazabilidadRepositoryPort = trazabilidadRepositoryPort;
    }

    @Override
    public TrazabilidadQueryResult ejecutar(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento,
                                             String usuarioId, Long limit, Long offset, String ordenamiento,
                                             Boolean incluirDatosDetallados) {
        return trazabilidadRepositoryPort.buscarPorSolicitudId(solicitudId, fechaDesde, fechaHasta, tipoEvento,
                usuarioId, limit, offset, ordenamiento, incluirDatosDetallados);
    }
}
