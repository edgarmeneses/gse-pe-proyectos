package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import java.util.List;

public interface ConsultarSolicitudesPendientesOfflineUseCase {
    
    List<Solicitud> ejecutar(String oficinaCode, String dispositivoId, String fechaDesde, String fechaHasta,
                             String estadoSincronizacion, Long page, Long size, Boolean incluirDetalles);
}
