package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;

public interface ActualizarSolicitudUseCase {
    
    Solicitud ejecutar(String solicitudId, Solicitud solicitud);
}
