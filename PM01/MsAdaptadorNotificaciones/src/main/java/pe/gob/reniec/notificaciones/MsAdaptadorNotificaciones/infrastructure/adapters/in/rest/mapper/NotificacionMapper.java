package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.request.EnviarNotificacionRequest;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.response.ApiResponse;

public class NotificacionMapper {

    public static Notificacion toDomain(EnviarNotificacionRequest request) {
        // Stub implementation
        Notificacion notificacion = new Notificacion();
        notificacion.setPlantillaId(request.getPlantillaId());
        notificacion.setAsunto(request.getAsunto());
        // ... map other fields
        return notificacion;
    }

    public static ApiResponse<Notificacion> toResponse(Notificacion notificacion) {
        // Stub implementation
        ApiResponse<Notificacion> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(notificacion);
        return response;
    }
}
