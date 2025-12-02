package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record HorarioServicioDto(
    Long diaSemana,
    String nombreDia,
    String horaInicio,
    String horaFin,
    Long capacidadPorFranja,
    Long duracionFranjaMinutos,
    Boolean activo
) {}
