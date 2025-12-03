package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Actualizar Documento
 */
public record ActualizarDocumentoResponseDto(
    String id,
    List<String> camposActualizados,
    String updatedAt,
    String estadoDocumento
) {}
