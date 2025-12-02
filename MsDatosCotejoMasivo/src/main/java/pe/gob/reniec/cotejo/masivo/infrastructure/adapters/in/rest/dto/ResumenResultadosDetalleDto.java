package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public record ResumenResultadosDetalleDto(
    Integer totalCorrectos,
    Integer totalIncorrectos,
    Integer totalNoEncontrados,
    Integer totalFallecidos,
    Integer totalRestringidos,
    Integer totalCaducados,
    Integer totalErrores
) {}
