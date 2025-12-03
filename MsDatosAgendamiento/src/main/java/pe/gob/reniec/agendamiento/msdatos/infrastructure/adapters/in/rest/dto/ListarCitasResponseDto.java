package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ListarCitasResponseDto(
    Boolean success,
    List<CitaDto> data,
    PaginacionDto paginacion,
    MetadataDto metadata
) {
    public record CitaDto(
        String citaId,
        String codigoCita,
        EstadoDto estado,
        SedeServicioDto sedeServicio,
        SolicitanteDto solicitante,
        String numeroTramite,
        ProgramacionDto programacion,
        TecnicoAsignadoDto tecnicoAsignado
    ) {}

    public record EstadoDto(
        String codigo,
        String descripcion
    ) {}

    public record SedeServicioDto(
        String codigoSede,
        String nombreSede
    ) {}

    public record SolicitanteDto(
        String dni,
        String nombreCompleto
    ) {}

    public record ProgramacionDto(
        String fechaCita,
        String horaCita
    ) {}

    public record TecnicoAsignadoDto(
        String idTecnico,
        String nombreCompleto
    ) {}

    public record PaginacionDto(
        Integer totalRegistros,
        Integer totalPaginas,
        Integer paginaActual,
        Integer registrosPorPagina,
        Boolean tieneAnterior,
        Boolean tieneSiguiente
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
