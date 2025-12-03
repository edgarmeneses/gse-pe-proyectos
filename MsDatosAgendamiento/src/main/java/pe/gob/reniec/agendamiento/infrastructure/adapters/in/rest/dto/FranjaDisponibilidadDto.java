package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record FranjaDisponibilidadDto(
    String idDisponibilidad,
    String horaInicio,
    String horaFin,
    Long capacidadTotal,
    Long capacidadOcupada,
    Long capacidadDisponible,
    String estado
) {}
