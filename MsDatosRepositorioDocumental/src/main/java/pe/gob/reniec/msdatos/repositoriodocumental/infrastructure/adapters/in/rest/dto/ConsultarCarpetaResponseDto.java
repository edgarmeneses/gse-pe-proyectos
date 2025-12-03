package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response: Consultar Carpeta
 */
public class ConsultarCarpetaResponseDto {
    private FolderDto folder;
    private PaginaDto page;
    private ContentsDto contents;

    public ConsultarCarpetaResponseDto() {
    }

    public ConsultarCarpetaResponseDto(FolderDto folder, PaginaDto page, ContentsDto contents) {
        this.folder = folder;
        this.page = page;
        this.contents = contents;
    }

    public FolderDto getFolder() {
        return folder;
    }

    public void setFolder(FolderDto folder) {
        this.folder = folder;
    }

    public PaginaDto getPage() {
        return page;
    }

    public void setPage(PaginaDto page) {
        this.page = page;
    }

    public ContentsDto getContents() {
        return contents;
    }

    public void setContents(ContentsDto contents) {
        this.contents = contents;
    }
}
