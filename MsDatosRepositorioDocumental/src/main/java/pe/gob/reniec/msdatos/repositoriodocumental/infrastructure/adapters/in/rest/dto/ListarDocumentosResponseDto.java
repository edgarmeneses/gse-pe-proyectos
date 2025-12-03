package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Listar Documentos
 */
public record ListarDocumentosResponseDto(
    PaginaDto page,
    List<DocumentoItemDto> content
) {}
