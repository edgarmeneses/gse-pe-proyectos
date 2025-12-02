package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record CrearCitaRequestDto(
    SedeServicioDto sedeServicio,
    SolicitudDto solicitud,
    SolicitanteDto solicitante,
    ProgramacionDto programacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String observaciones
) {}
