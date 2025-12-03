package pe.gob.pj.solicitudes.data.domain.ports.out;

import pe.gob.pj.solicitudes.data.application.query.SolicitudQueryResult;
import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import java.util.List;

public interface SolicitudRepositoryPort {
    
    Solicitud guardar(Solicitud solicitud);
    
    Solicitud actualizar(String solicitudId, Solicitud solicitud);
    
    Solicitud buscarPorId(String solicitudId);
    
    SolicitudQueryResult listar(String estado, String tipoTramite, String codigoOficina, String dniSolicitante,
                                 String usuarioAsignado, String fechaDesde, String fechaHasta, String prioridad,
                                 Boolean soloVencidas, Long page, Long size, String sort, String direction);
    
    List<Solicitud> buscarPendientesOffline(String oficinaCode, String dispositivoId, String fechaDesde,
                                            String fechaHasta, String estadoSincronizacion, Long page, Long size,
                                            Boolean incluirDetalles);
    
    Boolean verificarDuplicados(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento,
                                String usuarioId, Long limit, Long offset, String ordenamiento,
                                Boolean incluirDatosDetallados);
}
