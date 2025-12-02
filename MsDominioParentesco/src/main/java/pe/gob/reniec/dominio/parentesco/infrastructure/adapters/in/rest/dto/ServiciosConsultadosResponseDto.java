package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record ServiciosConsultadosResponseDto(
    Boolean msSagaAPD,
    Boolean msDatosActas,
    Boolean msDatosParentesco
) {}
