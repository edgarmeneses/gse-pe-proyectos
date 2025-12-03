package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record RegistrarExcepcionHorariaRequestDto(
    String codigoSede,
    String fechaExcepcion,
    String tipoExcepcion,
    String descripcion,
    HorarioEspecialDto horarioEspecial,
    Boolean afectaCitasExistentes,
    Boolean notificarAfectados
) {
    public record HorarioEspecialDto(
        String horaInicio,
        String horaFin,
        Integer capacidadPorFranja
    ) {}
}
