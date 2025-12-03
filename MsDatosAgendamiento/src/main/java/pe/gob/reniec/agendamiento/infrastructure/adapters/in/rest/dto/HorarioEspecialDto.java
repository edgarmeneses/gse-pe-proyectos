package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record HorarioEspecialDto(
    String horaInicio,
    String horaFin,
    Long capacidadPorFranja
) {}
