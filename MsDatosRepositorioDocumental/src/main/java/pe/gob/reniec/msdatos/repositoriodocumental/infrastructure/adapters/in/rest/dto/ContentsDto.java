package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Contenido de carpeta (subcarpetas y documentos)
 */
public class ContentsDto {
    private List<CarpetaItemDto> folders;
    private List<DocumentoInfoDto> documents;

    public ContentsDto() {
    }

    public ContentsDto(List<CarpetaItemDto> folders, List<DocumentoInfoDto> documents) {
        this.folders = folders;
        this.documents = documents;
    }

    public List<CarpetaItemDto> getFolders() {
        return folders;
    }

    public void setFolders(List<CarpetaItemDto> folders) {
        this.folders = folders;
    }

    public List<DocumentoInfoDto> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentoInfoDto> documents) {
        this.documents = documents;
    }
}
