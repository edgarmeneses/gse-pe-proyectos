package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO para respuesta detallada de una Solicitud individual
 * Usado en GET /solicitudes/{id}
 */
public record SolicitudDetalleDto(
        String solicitudId,
        String numeroSolicitud,
        String estado,
        String tipoTramite,
        String subTipoTramite,
        String prioridad,
        String tipoSolicitante,
        
        // Solicitante
        SolicitanteDto solicitante,
        
        // Requisitos y datos específicos
        List<RequisitoCumplidoDto> requisitosCumplidos,
        DatosEspecificosTramiteDto datosEspecificosTramite,
        List<DocumentoAdjuntoDto> documentosAdjuntos,
        
        // Pago
        PagoDto pago,
        
        // Observaciones
        String observaciones,
        
        // Auditoría y seguimiento
        LocalDateTime fechaRegistro,
        LocalDateTime fechaVencimiento,
        String usuarioRegistro,
        String usuarioAsignado,
        OficinaRegistroDto oficinaRegistro,
        
        // Estimaciones y estado
        Long tiempoEstimadoResolucion,
        Boolean requiereDiligencia,
        
        // Campos calculados (presentación)
        Integer diasTranscurridos,
        Integer diasRestantes,
        String urlSeguimiento,
        List<SiguientePasoDto> siguientesPasos
) {
}
