package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para respuesta de Solicitud individual
 * Este DTO representa un item en la lista de data de la respuesta API
 */
public record SolicitudResponseDto(
        String solicitudId,
        String numeroSolicitud,
        String estado,
        String tipoTramite,
        String subTipoTramite,
        String dniSolicitante,
        String nombresSolicitante,
        LocalDateTime fechaRegistro,
        LocalDateTime fechaVencimiento,
        String prioridad,
        String usuarioAsignado,
        String oficinaRegistro,
        Integer diasTranscurridos,
        Integer diasRestantes
) {
}
