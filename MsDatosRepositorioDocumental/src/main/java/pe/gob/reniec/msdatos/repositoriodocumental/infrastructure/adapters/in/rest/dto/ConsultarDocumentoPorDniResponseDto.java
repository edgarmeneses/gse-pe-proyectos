package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Consultar Documentos Por DNI
 */
public record ConsultarDocumentoPorDniResponseDto(
    CiudadanoDto ciudadano,
    PaginaDto page,
    List<DocumentoDetalleDto> content
) {}
