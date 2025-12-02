package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.DocumentoRequestDto;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.DocumentoResponseDto;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ConsultarDocumentoResponseDto;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ActualizarDocumentoResponseDto;
import java.util.List;

public class DocumentoDtoMapper {

    public static DocumentoResponseDto toResponseDto(Documento documento) {
        return new DocumentoResponseDto(
            documento.getId(),
            documento.getMetadata(),
            documento.getCreatedAt(),
            documento.getEstadoDocumento()
        );
    }

    public static ConsultarDocumentoResponseDto toConsultarResponseDto(Documento documento) {
        return new ConsultarDocumentoResponseDto(
            documento.getArchivoBase64(),
            documento.getCarpetaId(),
            documento.getMetadata(),
            documento.getEstadoDocumento()
        );
    }

    public static ActualizarDocumentoResponseDto toActualizarResponseDto(Documento documento, List<String> camposActualizados) {
        return new ActualizarDocumentoResponseDto(
            documento.getId(),
            camposActualizados,
            documento.getUpdatedAt(),
            documento.getEstadoDocumento()
        );
    }
}
