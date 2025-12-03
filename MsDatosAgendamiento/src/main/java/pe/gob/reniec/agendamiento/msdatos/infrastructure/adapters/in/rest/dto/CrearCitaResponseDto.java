package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record CrearCitaResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String citaId,
        String codigoCita,
        String estado,
        SedeServicioDto sedeServicio,
        SolicitanteDto solicitante,
        ProgramacionDto programacion,
        TecnicoAsignadoDto tecnicoAsignado,
        String tokenReagendamiento,
        String fechaLimiteReagendamiento,
        String fechaRegistro,
        String usuarioRegistro,
        LinksDto _links
    ) {}

    public record SedeServicioDto(
        String codigoSede,
        String nombreSede,
        String direccion
    ) {}

    public record SolicitanteDto(
        String dni,
        String nombreCompleto
    ) {}

    public record ProgramacionDto(
        String fechaCita,
        String horaCita,
        String fechaHoraCompleta
    ) {}

    public record TecnicoAsignadoDto(
        String idTecnico,
        String nombreCompleto
    ) {}

    public record LinksDto(
        String self,
        String actualizar,
        String cancelar,
        String historial
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
