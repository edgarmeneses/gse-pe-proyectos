package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConfigurarDisponibilidadRequestDto(
    SedeServicioDto sedeServicio,
    List<HorarioServicioDto> horarioServicio,
    RangoAplicacionDto rangoAplicacion,
    Boolean generarDisponibilidadAutomatica
) {
    public record SedeServicioDto(
        String codigoSede,
        String nombreSede,
        String direccion,
        Integer capacidadDiariaMaxima,
        Integer tiempoAtencionMinutos
    ) {}

    public record HorarioServicioDto(
        Integer diaSemana,
        String nombreDia,
        String horaInicio,
        String horaFin,
        Integer capacidadPorFranja,
        Integer duracionFranjaMinutos,
        Boolean activo
    ) {}

    public record RangoAplicacionDto(
        String fechaDesde,
        String fechaHasta
    ) {}
}
