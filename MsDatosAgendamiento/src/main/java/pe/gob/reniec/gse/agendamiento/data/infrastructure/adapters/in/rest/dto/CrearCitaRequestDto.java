package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record CrearCitaRequestDto(
    SedeServicioDto sedeServicio,
    SolicitudDto solicitud,
    SolicitanteDto solicitante,
    ProgramacionDto programacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String observaciones
) {}
