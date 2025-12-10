package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.out;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Paginacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.FiltrosHistorial;
import java.util.Optional;
import java.util.UUID;

public interface NotificacionDataPort {
    Notificacion save(Notificacion notificacion);
    Optional<Notificacion> findById(UUID notificacionId);
    Paginacion<Notificacion> findByFilters(FiltrosHistorial filtros);
}
