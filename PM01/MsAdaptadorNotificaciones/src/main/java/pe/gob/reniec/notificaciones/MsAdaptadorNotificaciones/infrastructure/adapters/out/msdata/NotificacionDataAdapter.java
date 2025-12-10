package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.out.msdata;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Paginacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.FiltrosHistorial;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.out.NotificacionDataPort;

import java.util.Optional;
import java.util.UUID;

public class NotificacionDataAdapter implements NotificacionDataPort {

    @Override
    public Notificacion save(Notificacion notificacion) {
        // Stub implementation: In a real scenario, this would call an external service or DB
        notificacion.setNotificacionId(UUID.randomUUID());
        notificacion.setEstado("CREATED");
        return notificacion;
    }

    @Override
    public Optional<Notificacion> findById(UUID notificacionId) {
        // Stub implementation
        Notificacion notificacion = new Notificacion();
        notificacion.setNotificacionId(notificacionId);
        notificacion.setEstado("DELIVERED");
        return Optional.of(notificacion);
    }

    @Override
    public Paginacion<Notificacion> findByFilters(FiltrosHistorial filtros) {
        // Stub implementation
        Paginacion<Notificacion> paginacion = new Paginacion<>();
        paginacion.setPage(filtros.getPage());
        paginacion.setPageSize(filtros.getPageSize());
        paginacion.setTotalElements(0);
        return paginacion;
    }
}
