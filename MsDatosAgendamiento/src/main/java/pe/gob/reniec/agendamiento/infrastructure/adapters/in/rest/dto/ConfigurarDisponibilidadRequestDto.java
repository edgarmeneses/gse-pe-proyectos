package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConfigurarDisponibilidadRequestDto(
    SedeServicioDto sedeServicio,
    List<HorarioServicioDto> horarioServicio,
    RangoAplicacionDto rangoAplicacion,
    Boolean generarDisponibilidadAutomatica
) {}
