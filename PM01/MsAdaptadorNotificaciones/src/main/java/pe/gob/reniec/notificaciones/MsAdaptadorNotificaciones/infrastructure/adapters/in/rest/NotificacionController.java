package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest;

import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.application.service.EnviarNotificacionService;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.application.service.ConsultarEstadoNotificacionService;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.application.service.ConsultarHistorialNotificacionesService;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Notificacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.Paginacion;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model.FiltrosHistorial;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.request.EnviarNotificacionRequest;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.response.ApiResponse;
import pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.mapper.NotificacionMapper;

import java.util.UUID;

public class NotificacionController {

    private final EnviarNotificacionService enviarNotificacionService;
    private final ConsultarEstadoNotificacionService consultarEstadoNotificacionService;
    private final ConsultarHistorialNotificacionesService consultarHistorialNotificacionesService;

    public NotificacionController(
            EnviarNotificacionService enviarNotificacionService,
            ConsultarEstadoNotificacionService consultarEstadoNotificacionService,
            ConsultarHistorialNotificacionesService consultarHistorialNotificacionesService) {
        this.enviarNotificacionService = enviarNotificacionService;
        this.consultarEstadoNotificacionService = consultarEstadoNotificacionService;
        this.consultarHistorialNotificacionesService = consultarHistorialNotificacionesService;
    }

    // POST /api/v1/notificaciones/MsAdaptadorNotificaciones/enviar
    public ApiResponse<Notificacion> enviar(EnviarNotificacionRequest request) {
        Notificacion notificacion = NotificacionMapper.toDomain(request);
        Notificacion result = enviarNotificacionService.enviar(notificacion);
        return NotificacionMapper.toResponse(result);
    }

    // GET /api/v1/notificaciones/MsAdaptadorNotificaciones/{notificacionId}/estado
    public ApiResponse<Notificacion> consultarEstado(String notificacionId, boolean incluirDetalles, boolean incluirContenido) {
        Notificacion result = consultarEstadoNotificacionService.consultarEstado(UUID.fromString(notificacionId), incluirDetalles, incluirContenido);
        return NotificacionMapper.toResponse(result);
    }

    // GET /api/v1/notificaciones/MsAdaptadorNotificaciones/historial
    public ApiResponse<Paginacion<Notificacion>> consultarHistorial(
            String dni, String fechaInicio, String fechaFin, String canal, String estado,
            String plantillaId, String sistemaOrigen, String oficinaOrigen,
            Integer page, Integer pageSize, String orderBy, String orderDir) {
        
        FiltrosHistorial filtros = new FiltrosHistorial();
        filtros.setDni(dni);
        // ... set other filters
        
        Paginacion<Notificacion> result = consultarHistorialNotificacionesService.consultarHistorial(filtros);
        
        ApiResponse<Paginacion<Notificacion>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(result);
        return response;
    }
}
