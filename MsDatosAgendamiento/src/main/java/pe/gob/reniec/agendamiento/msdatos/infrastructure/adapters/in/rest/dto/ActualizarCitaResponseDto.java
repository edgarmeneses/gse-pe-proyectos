package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record ActualizarCitaResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String citaId,
        String codigoCita,
        String estado,
        ProgramacionAnteriorDto programacionAnterior,
        ProgramacionNuevaDto programacionNueva,
        SedeServicioDto sedeServicio,
        TecnicoAsignadoDto tecnicoAsignado,
        String tokenReagendamiento,
        String fechaLimiteReagendamiento,
        Integer cantidadReagendamientos,
        String fechaActualizacion,
        String usuarioActualizacion,
        LinksDto _links
    ) {}

    public record ProgramacionAnteriorDto(
        String fechaCita,
        String horaCita
    ) {}

    public record ProgramacionNuevaDto(
        String fechaCita,
        String horaCita,
        String fechaHoraCompleta
    ) {}

    public record SedeServicioDto(
        String codigoSede,
        String nombreSede,
        String direccion
    ) {}

    public record TecnicoAsignadoDto(
        String idTecnico,
        String nombreCompleto
    ) {}

    public record LinksDto(
        String self,
        String cancelar,
        String historial
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
