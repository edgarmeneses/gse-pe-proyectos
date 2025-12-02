package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record RegistrarResultadosCotejoRequestDto(
    List<ResultadoCotejoItemDto> resultados
) {}
