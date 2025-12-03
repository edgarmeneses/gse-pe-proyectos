package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Response: Consultar Carpeta
 */
public record ConsultarCarpetaResponseDto(
    FolderDto folder,
    PaginaDto page,
    ContentsDto contents
) {}
