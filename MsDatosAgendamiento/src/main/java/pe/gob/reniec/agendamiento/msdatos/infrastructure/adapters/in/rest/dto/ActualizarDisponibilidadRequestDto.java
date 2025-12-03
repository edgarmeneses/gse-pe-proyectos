package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record ActualizarDisponibilidadRequestDto(
    Integer capacidadTotal,
    String estado,
    String motivoCambio
) {}
