package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO Response: Listar Documentos
 */
public class ListarDocumentosResponseDto {
    private final PaginaDto page;
    private final List<DocumentoItemDto> content;

    public ListarDocumentosResponseDto(PaginaDto page, List<DocumentoItemDto> content) {
        this.page = page;
        this.content = content;
    }

    public PaginaDto page() { return page; }
    public List<DocumentoItemDto> content() { return content; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListarDocumentosResponseDto that = (ListarDocumentosResponseDto) o;
        return Objects.equals(page, that.page) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, content);
    }

    @Override
    public String toString() {
        return "ListarDocumentosResponseDto{" +
                "page=" + page +
                ", content=" + content +
                '}';
    }
}
