package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.application.service;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Paginacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.FiltrosHistorial;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.in.ConsultarHistorialNotificacionesUseCase;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.out.NotificacionDataPort;

public class ConsultarHistorialNotificacionesService implements ConsultarHistorialNotificacionesUseCase {

    private final NotificacionDataPort notificacionDataPort;

    public ConsultarHistorialNotificacionesService(NotificacionDataPort notificacionDataPort) {
        this.notificacionDataPort = notificacionDataPort;
    }

    @Override
    public Paginacion<Notificacion> consultarHistorial(FiltrosHistorial filtros) {
        return notificacionDataPort.findByFilters(filtros);
    }
}
