package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Listar Documentos
 */
public class ListarDocumentosResponseDto {
    private PaginaDto page;
    private List<DocumentoItemDto> content;

    public ListarDocumentosResponseDto() {
    }

    public ListarDocumentosResponseDto(PaginaDto page, List<DocumentoItemDto> content) {
        this.page = page;
        this.content = content;
    }

    public PaginaDto getPage() {
        return page;
    }

    public void setPage(PaginaDto page) {
        this.page = page;
    }

    public List<DocumentoItemDto> getContent() {
        return content;
    }

    public void setContent(List<DocumentoItemDto> content) {
        this.content = content;
    }
}
