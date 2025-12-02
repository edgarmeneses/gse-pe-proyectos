package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record PoblacionVinculosPosiblesResponseDto(
    Integer totalEncontrados,
    List<VinculoConsanguineoResponseDto> vinculosConsanguineos,
    List<VinculoAfinidadResponseDto> vinculosAfinidad
) {}
