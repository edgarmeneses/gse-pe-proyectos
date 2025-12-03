package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.application.query.SolicitudQueryResult;

public interface ListarSolicitudesUseCase {
    
    SolicitudQueryResult ejecutar(String estado, String tipoTramite, String codigoOficina, String dniSolicitante,
                                   String usuarioAsignado, String fechaDesde, String fechaHasta, String prioridad,
                                   Boolean soloVencidas, Long page, Long size, String sort, String direction);
}
