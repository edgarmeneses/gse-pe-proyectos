package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.application.service;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.in.EnviarNotificacionUseCase;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.out.NotificacionDataPort;

public class EnviarNotificacionService implements EnviarNotificacionUseCase {

    private final NotificacionDataPort notificacionDataPort;

    public EnviarNotificacionService(NotificacionDataPort notificacionDataPort) {
        this.notificacionDataPort = notificacionDataPort;
    }

    @Override
    public Notificacion enviar(Notificacion notificacion) {
        // Logic to send notification would go here (orchestration)
        // For now, we just save it via the port as per instructions (stub logic mostly)
        // In a real scenario, we would call external providers here via another port.
        // But the prompt says "MsDominio: NO define Repository (usa DataPort hacia MsData)"
        // It doesn't explicitly say about external providers ports, but it's implied for an adapter.
        // However, to keep it simple and follow the prompt's "MsDominio" structure strictly:
        return notificacionDataPort.save(notificacion);
    }
}
