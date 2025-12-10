package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.in;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Paginacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.FiltrosHistorial;

public interface ConsultarHistorialNotificacionesUseCase {
    Paginacion<Notificacion> consultarHistorial(FiltrosHistorial filtros);
}
