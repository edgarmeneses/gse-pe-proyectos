package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.application.service;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.in.ConsultarEstadoNotificacionUseCase;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.out.NotificacionDataPort;
import java.util.UUID;

public class ConsultarEstadoNotificacionService implements ConsultarEstadoNotificacionUseCase {

    private final NotificacionDataPort notificacionDataPort;

    public ConsultarEstadoNotificacionService(NotificacionDataPort notificacionDataPort) {
        this.notificacionDataPort = notificacionDataPort;
    }

    @Override
    public Notificacion consultarEstado(UUID notificacionId, boolean incluirDetalles, boolean incluirContenido) {
        return notificacionDataPort.findById(notificacionId)
                .orElseThrow(() -> new RuntimeException("Notificacion not found"));
    }
}
