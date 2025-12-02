package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record de petición para calificar documentos
 */
public record CalificarDocumentoRequestDto(
    String solicitudId,
    String tramiteId,
    String tipoTramite,
    List<DocumentoDto> documentos,
    ParametrosValidacionDto parametrosValidacion,
    String usuarioSolicita,
    String oficinaOrigen,
    String fechaSolicitud,
    String observaciones
) {}
