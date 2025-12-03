package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence;

import pe.gob.pj.solicitudes.data.application.query.TrazabilidadQueryResult;
import pe.gob.pj.solicitudes.data.domain.ports.out.TrazabilidadRepositoryPort;

public class TrazabilidadRepositoryAdapter implements TrazabilidadRepositoryPort {

    @Override
    public TrazabilidadQueryResult buscarPorSolicitudId(String solicitudId, String fechaDesde, String fechaHasta,
                                             String tipoEvento, String usuarioId, Long limit, Long offset,
                                             String ordenamiento, Boolean incluirDatosDetallados) {
        // Aquí iría la lógica de búsqueda real (sin tecnología específica)
        throw new UnsupportedOperationException("Método no implementado - requiere tecnología de persistencia");
    }
}
