package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO: Contenido de carpeta (subcarpetas y documentos)
 */
public class ContentsDto {
    private final List<CarpetaItemDto> folders;
    private final List<DocumentoInfoDto> documents;

    public ContentsDto(List<CarpetaItemDto> folders, List<DocumentoInfoDto> documents) {
        this.folders = folders;
        this.documents = documents;
    }

    public List<CarpetaItemDto> folders() { return folders; }
    public List<DocumentoInfoDto> documents() { return documents; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentsDto that = (ContentsDto) o;
        return Objects.equals(folders, that.folders) && Objects.equals(documents, that.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folders, documents);
    }

    @Override
    public String toString() {
        return "ContentsDto{" +
                "folders=" + folders +
                ", documents=" + documents +
                '}';
    }
}
