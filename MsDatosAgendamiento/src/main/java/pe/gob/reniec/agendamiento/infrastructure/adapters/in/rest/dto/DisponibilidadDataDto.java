package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record DisponibilidadDataDto(
    String idDisponibilidad,
    SedeServicioDto sedeServicio,
    String fecha,
    String diaSemana,
    Boolean esHabil,
    String motivoNoHabil,
    String horaInicio,
    String horaFin,
    Long capacidadTotal,
    Long capacidadOcupada,
    Long capacidadDisponible,
    String estado,
    List<FranjaDisponibilidadDto> franjas
) {}
