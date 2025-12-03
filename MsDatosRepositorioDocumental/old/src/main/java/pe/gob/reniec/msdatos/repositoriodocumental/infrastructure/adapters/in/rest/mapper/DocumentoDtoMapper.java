package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ListarDocumentosResponseDto toListarResponseDto(List<Documento> documentos, Integer page, Integer size) {
        PageDto pageDto = new PageDto(
            page,
            size,
            (long) documentos.size(),
            (documentos.size() / size) + 1,
            false,
            false
        );
        
        List<DocumentoInfoDto> content = documentos.stream()
            .map(doc -> new DocumentoInfoDto(
                doc.getId(),
                (String) doc.getMetadata().getOrDefault("nombreArchivo", ""),
                (String) doc.getMetadata().getOrDefault("tipoDocumento", ""),
                "",
                doc.getCarpetaId(),
                doc.getEstadoDocumento(),
                (String) doc.getMetadata().getOrDefault("mimeType", ""),
                0,
                doc.getCreatedAt(),
                doc.getUpdatedAt()
            ))
            .collect(Collectors.toList());
        
        return new ListarDocumentosResponseDto(pageDto, content);
    }

    public static ConsultarDocumentoPorDniResponseDto toConsultarPorDniResponseDto(List<Documento> documentos, String dni, Integer page, Integer size) {
        CiudadanoDto ciudadanoDto = new CiudadanoDto(dni, "");
        
        PageDto pageDto = new PageDto(
            page,
            size,
            (long) documentos.size(),
            (documentos.size() / size) + 1,
            false,
            page > 0
        );
        
        List<DocumentoInfoDto> content = documentos.stream()
            .map(doc -> new DocumentoInfoDto(
                doc.getId(),
                (String) doc.getMetadata().getOrDefault("nombreArchivo", ""),
                (String) doc.getMetadata().getOrDefault("tipoDocumento", ""),
                "",
                doc.getCarpetaId(),
                doc.getEstadoDocumento(),
                (String) doc.getMetadata().getOrDefault("mimeType", ""),
                0,
                doc.getCreatedAt(),
                doc.getUpdatedAt()
            ))
            .collect(Collectors.toList());
        
        return new ConsultarDocumentoPorDniResponseDto(ciudadanoDto, pageDto, content);
    }
}
