package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ContentsDto(
    List<SubFolderDto> folders,
    List<DocumentoItemDto> documents
) {}
