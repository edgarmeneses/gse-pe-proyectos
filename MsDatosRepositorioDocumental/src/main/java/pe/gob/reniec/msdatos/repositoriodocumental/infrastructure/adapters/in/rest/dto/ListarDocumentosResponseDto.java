package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ListarDocumentosResponseDto(
    PageDto page,
    List<DocumentoInfoDto> content
) {}
