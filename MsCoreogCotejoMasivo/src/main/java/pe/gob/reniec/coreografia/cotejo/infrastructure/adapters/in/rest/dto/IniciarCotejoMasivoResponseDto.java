package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record IniciarCotejoMasivoResponseDto(
    Boolean success,
    DatosCotejoDto data,
    MetadataDto metadata
) {}
