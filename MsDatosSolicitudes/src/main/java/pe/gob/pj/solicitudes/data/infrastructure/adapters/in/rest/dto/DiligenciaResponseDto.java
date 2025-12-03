package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record DiligenciaResponseDto(
        String diligenciaId,
        String numeroDiligencia,
        String solicitudId,
        String numeroSolicitud,
        String estado,
        String tipoDiligencia,
        String entidadDestino,
        String motivoDiligencia,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaVencimiento,
        Long plazoRespuesta,
        Integer diasTranscurridos,
        Integer diasRestantes,
        String prioridad,
        OficinaResponsableDto oficinaResponsable,
        String usuarioSolicitante,
        String estadoOficio,
        List<DocumentoGeneradoDto> documentosGenerados
) {
}
