package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record CancelarCitaRequestDto(
    String motivoCancelacion,
    String tokenReagendamiento,
    String observaciones
) {}
