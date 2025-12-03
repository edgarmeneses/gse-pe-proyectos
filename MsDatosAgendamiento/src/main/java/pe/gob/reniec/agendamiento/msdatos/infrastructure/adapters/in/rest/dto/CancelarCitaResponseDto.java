package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record CancelarCitaResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String citaId,
        String codigoCita,
        String estadoAnterior,
        String estadoNuevo,
        String fechaCancelacion,
        String usuarioCancelacion,
        String motivoCancelacion,
        Boolean disponibilidadLiberada
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
