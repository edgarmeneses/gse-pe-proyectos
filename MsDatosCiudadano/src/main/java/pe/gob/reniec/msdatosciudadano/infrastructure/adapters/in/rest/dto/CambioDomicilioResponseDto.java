package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CambioDomicilioResponseDto (
    LocalDateTime fechaDesde,
    LocalDateTime fechaHasta,
    Integer totalCircunscripciones,
    Integer totalCambiosDetectados,
    List<CircunscripcionDto> circunscripciones
) {
}
