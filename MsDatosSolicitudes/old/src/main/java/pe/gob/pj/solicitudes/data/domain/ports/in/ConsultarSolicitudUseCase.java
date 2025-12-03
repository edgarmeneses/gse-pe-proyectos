package pe.gob.pj.solicitudes.data.domain.ports.in;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;

public interface ConsultarSolicitudUseCase {
    Solicitud consultar(Long id);
}
