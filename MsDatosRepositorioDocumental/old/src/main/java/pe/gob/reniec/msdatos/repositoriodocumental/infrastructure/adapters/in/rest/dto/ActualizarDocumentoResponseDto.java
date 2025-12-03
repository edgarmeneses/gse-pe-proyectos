package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ActualizarDocumentoResponseDto(
    String id,
    List<String> camposActualizados,
    LocalDateTime updatedAt,
    String estadoDocumento
) {}
