package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Contenido de carpeta (subcarpetas y documentos)
 */
public record ContentsDto(
    List<CarpetaItemDto> folders,
    List<DocumentoInfoDto> documents
) {}
