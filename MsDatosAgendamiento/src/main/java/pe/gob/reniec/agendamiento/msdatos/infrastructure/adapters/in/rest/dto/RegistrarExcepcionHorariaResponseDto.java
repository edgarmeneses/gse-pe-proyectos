package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record RegistrarExcepcionHorariaResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String idExcepcion,
        String codigoSede,
        String nombreSede,
        String fechaExcepcion,
        String tipoExcepcion,
        String descripcion,
        HorarioEspecialDto horarioEspecial,
        CitasAfectadasDto citasAfectadas,
        String fechaRegistro,
        String usuarioRegistro
    ) {}

    public record HorarioEspecialDto(
        String horaInicio,
        String horaFin
    ) {}

    public record CitasAfectadasDto(
        Integer cantidad,
        String accion,
        List<String> citasIds
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
