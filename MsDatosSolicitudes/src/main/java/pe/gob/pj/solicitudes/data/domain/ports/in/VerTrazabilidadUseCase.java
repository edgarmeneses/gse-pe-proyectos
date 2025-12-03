package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.application.query.TrazabilidadQueryResult;

public interface VerTrazabilidadUseCase {
    
    TrazabilidadQueryResult ejecutar(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento,
                                      String usuarioId, Long limit, Long offset, String ordenamiento,
                                      Boolean incluirDatosDetallados);
}
