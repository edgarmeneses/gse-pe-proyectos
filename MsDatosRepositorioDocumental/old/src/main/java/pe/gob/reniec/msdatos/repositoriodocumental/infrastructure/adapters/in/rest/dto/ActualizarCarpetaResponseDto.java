package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ActualizarCarpetaResponseDto(
    String id,
    LocalDateTime updateAt,
    List<String> camposActualizados
) {}
