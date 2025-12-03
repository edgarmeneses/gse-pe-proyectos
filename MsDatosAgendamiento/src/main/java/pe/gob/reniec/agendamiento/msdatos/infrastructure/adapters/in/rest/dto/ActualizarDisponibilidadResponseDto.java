package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record ActualizarDisponibilidadResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String idDisponibilidad,
        String fecha,
        String horaInicio,
        String horaFin,
        Integer capacidadAnterior,
        Integer capacidadNueva,
        Integer capacidadOcupada,
        Integer capacidadDisponible,
        String estadoAnterior,
        String estadoNuevo,
        String fechaActualizacion,
        String usuarioActualizacion
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
