package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

public record ConsultarCarpetaResponseDto(
    FolderDto folder,
    PageDto page,
    ContentsDto contents
) {}
