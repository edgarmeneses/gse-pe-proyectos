package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record CrearCitaRequestDto(
    SedeServicioDto sedeServicio,
    SolicitudDto solicitud,
    SolicitanteDto solicitante,
    ProgramacionDto programacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String observaciones
) {
    public record SedeServicioDto(
        String codigoSede,
        String nombreSede
    ) {}

    public record SolicitudDto(
        String idSolicitud,
        String numeroTramite
    ) {}

    public record SolicitanteDto(
        String dni,
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        String email,
        String telefono
    ) {}

    public record ProgramacionDto(
        String fechaCita,
        String horaCita,
        String idDisponibilidad
    ) {}

    public record TecnicoAsignadoDto(
        String idTecnico,
        String nombreCompleto
    ) {}
}
