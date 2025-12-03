package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarpetaDtoMapper {

    public static CarpetaResponseDto toResponseDto(Carpeta carpeta) {
        return new CarpetaResponseDto(
            carpeta.getId(),
            carpeta.getCreatedAt(),
            carpeta.getEstadoCarpeta(),
            carpeta.getRuta()
        );
    }

    public static ActualizarCarpetaResponseDto toActualizarResponseDto(Carpeta carpeta, List<String> camposActualizados) {
        return new ActualizarCarpetaResponseDto(
            carpeta.getId(),
            carpeta.getUpdatedAt(),
            camposActualizados
        );
    }

    @SuppressWarnings("unchecked")
    public static ConsultarCarpetaResponseDto toConsultarCarpetaResponseDto(Map<String, Object> resultado) {
        Map<String, Object> folderData = (Map<String, Object>) resultado.get("folder");
        Map<String, Object> pageData = (Map<String, Object>) resultado.get("page");
        Map<String, Object> contentsData = (Map<String, Object>) resultado.get("contents");
        
        FolderDto folder = new FolderDto(
            (String) folderData.get("id"),
            (Map<String, Object>) folderData.get("metadata"),
            (String) folderData.get("path"),
            (String) folderData.get("estadoCarpeta"),
            (LocalDateTime) folderData.get("createdAt"),
            (LocalDateTime) folderData.get("updatedAt")
        );
        
        PageDto page = new PageDto(
            (Integer) pageData.get("number"),
            (Integer) pageData.get("size"),
            ((Number) pageData.get("totalElements")).longValue(),
            (Integer) pageData.get("totalPages"),
            (Boolean) pageData.get("hasNext"),
            (Boolean) pageData.getOrDefault("hasPrevious", false)
        );
        
        List<Map<String, Object>> foldersData = (List<Map<String, Object>>) contentsData.getOrDefault("folders", List.of());
        List<Map<String, Object>> documentsData = (List<Map<String, Object>>) contentsData.getOrDefault("documents", List.of());
        
        List<SubFolderDto> folders = foldersData.stream()
            .map(f -> new SubFolderDto(
                (String) f.get("id"),
                (Map<String, Object>) f.get("metadata"),
                (LocalDateTime) f.get("createdAt")
            ))
            .collect(Collectors.toList());
        
        List<DocumentoItemDto> documents = documentsData.stream()
            .map(d -> new DocumentoItemDto(
                (String) d.get("id"),
                (Map<String, Object>) d.get("metadata"),
                (LocalDateTime) d.get("createdAt")
            ))
            .collect(Collectors.toList());
        
        ContentsDto contents = new ContentsDto(folders, documents);
        
        return new ConsultarCarpetaResponseDto(folder, page, contents);
    }
}
