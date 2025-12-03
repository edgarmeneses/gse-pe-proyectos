package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record ActualizarCitaRequestDto(
    String tokenReagendamiento,
    ProgramacionDto nuevaProgramacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String motivoCambio,
    String observaciones
) {}
