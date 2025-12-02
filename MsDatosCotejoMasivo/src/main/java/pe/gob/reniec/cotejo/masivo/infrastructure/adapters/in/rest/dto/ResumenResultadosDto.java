package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public record ResumenResultadosDto(
    Integer totalCorrectos,
    Integer totalIncorrectos,
    Integer totalNoEncontrados,
    Integer totalFallecidos,
    Integer totalRestringidos,
    Integer totalErrores
) {}
