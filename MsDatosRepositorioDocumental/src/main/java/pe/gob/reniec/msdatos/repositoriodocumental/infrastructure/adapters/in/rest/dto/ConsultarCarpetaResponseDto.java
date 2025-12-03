package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO Response: Consultar Carpeta
 */
public class ConsultarCarpetaResponseDto {
    private final FolderDto folder;
    private final PaginaDto page;
    private final ContentsDto contents;

    public ConsultarCarpetaResponseDto(FolderDto folder, PaginaDto page, ContentsDto contents) {
        this.folder = folder;
        this.page = page;
        this.contents = contents;
    }

    public FolderDto folder() { return folder; }
    public PaginaDto page() { return page; }
    public ContentsDto contents() { return contents; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultarCarpetaResponseDto that = (ConsultarCarpetaResponseDto) o;
        return Objects.equals(folder, that.folder) && Objects.equals(page, that.page) && Objects.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folder, page, contents);
    }

    @Override
    public String toString() {
        return "ConsultarCarpetaResponseDto{" +
                "folder=" + folder +
                ", page=" + page +
                ", contents=" + contents +
                '}';
    }
}
