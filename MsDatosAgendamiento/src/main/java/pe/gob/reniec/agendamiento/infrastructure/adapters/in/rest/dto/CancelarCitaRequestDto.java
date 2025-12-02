package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record CancelarCitaRequestDto(
    String motivoCancelacion,
    String tokenReagendamiento,
    String observaciones
) {}
