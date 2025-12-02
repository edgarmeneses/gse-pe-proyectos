package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.UUID;

public record RegistrarResultadosCotejoResponseDto(
    UUID ejecucionId,
    Integer totalResultadosRecibidos,
    Integer totalResultadosInsertados,
    Integer totalResultadosRechazados,
    ResumenResultadosDto resumenResultados,
    List<ResultadoRechazadoDto> resultadosRechazados
) {}
