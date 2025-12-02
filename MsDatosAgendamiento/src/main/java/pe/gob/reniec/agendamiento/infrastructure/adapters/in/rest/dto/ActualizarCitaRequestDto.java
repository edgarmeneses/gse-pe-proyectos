package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record ActualizarCitaRequestDto(
    String tokenReagendamiento,
    ProgramacionDto nuevaProgramacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String motivoCambio,
    String observaciones
) {}
