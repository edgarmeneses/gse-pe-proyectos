package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultarCitaResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        String citaId,
        String codigoCita,
        EstadoDto estado,
        SedeServicioDto sedeServicio,
        SolicitudDto solicitud,
        SolicitanteDto solicitante,
        ProgramacionDto programacion,
        TecnicoAsignadoDto tecnicoAsignado,
        String tokenReagendamiento,
        String fechaLimiteReagendamiento,
        Integer cantidadReagendamientos,
        Integer maximoReagendamientos,
        String observaciones,
        String fechaRegistro,
        String usuarioRegistro,
        String fechaActualizacion,
        String usuarioActualizacion,
        List<HistorialDto> historial,
        LinksDto _links
    ) {}

    public record EstadoDto(
        String codigo,
        String descripcion,
        Boolean permiteModificacion,
        Boolean permiteCancelacion
    ) {}

    public record SedeServicioDto(
        String codigoSede,
        String nombreSede,
        String direccion,
        String telefono
    ) {}

    public record SolicitudDto(
        String idSolicitud,
        String numeroTramite
    ) {}

    public record SolicitanteDto(
        String dni,
        String nombreCompleto,
        String email,
        String telefono
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

    public record HistorialDto(
        String idHistorial,
        String fechaCambio,
        String estadoAnterior,
        String estadoNuevo,
        String fechaAnterior,
        String horaAnterior,
        String fechaNueva,
        String horaNueva,
        String motivoCambio,
        String usuarioCambio
    ) {}

    public record LinksDto(
        String self,
        String actualizar,
        String cancelar,
        String disponibilidad
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
