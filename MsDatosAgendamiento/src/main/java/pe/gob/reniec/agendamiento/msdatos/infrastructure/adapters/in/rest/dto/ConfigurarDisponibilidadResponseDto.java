package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record ConfigurarDisponibilidadResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String sedeServicioId,
        String codigoSede,
        String nombreSede,
        ConfiguracionDto configuracion,
        DisponibilidadGeneradaDto disponibilidadGenerada,
        String fechaConfiguracion,
        String usuarioConfiguracion
    ) {}

    public record ConfiguracionDto(
        Integer capacidadDiariaMaxima,
        Integer tiempoAtencionMinutos,
        Integer horariosConfigurados
    ) {}

    public record DisponibilidadGeneradaDto(
        Integer diasGenerados,
        Integer franjasGeneradas,
        String fechaDesde,
        String fechaHasta
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
