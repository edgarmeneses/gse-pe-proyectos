package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record ActualizarDisponibilidadRequestDto(
    Long capacidadTotal,
    String estado,
    String motivoCambio
) {}
