package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultarDocumentoPorDniResponseDto(
    CiudadanoDto ciudadano,
    PageDto page,
    List<DocumentoInfoDto> content
) {}
