package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.in;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import java.util.UUID;

public interface ConsultarEstadoNotificacionUseCase {
    Notificacion consultarEstado(UUID notificacionId, boolean incluirDetalles, boolean incluirContenido);
}
