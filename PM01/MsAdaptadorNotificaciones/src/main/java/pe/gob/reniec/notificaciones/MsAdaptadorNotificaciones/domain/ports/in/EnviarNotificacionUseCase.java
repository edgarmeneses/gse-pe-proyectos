package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.ports.in;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;

public interface EnviarNotificacionUseCase {
    Notificacion enviar(Notificacion notificacion);
}
