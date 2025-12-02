package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ListarRegistradoresResponseDto(
    Boolean success,
    ListaDataDto data,
    MetadataDto metadata,
    ErrorDto error
) {}
