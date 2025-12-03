package pe.gob.pj.solicitudes.data.domain.ports.out;

import pe.gob.pj.solicitudes.data.application.query.TrazabilidadQueryResult;

public interface TrazabilidadRepositoryPort {
    
    TrazabilidadQueryResult buscarPorSolicitudId(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento,
                                                  String usuarioId, Long limit, Long offset, String ordenamiento,
                                                  Boolean incluirDatosDetallados);
}
