package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Consultar Documentos Por DNI
 */
public class ConsultarDocumentoPorDniResponseDto {
    private CiudadanoDto ciudadano;
    private PaginaDto page;
    private List<DocumentoDetalleDto> content;

    public ConsultarDocumentoPorDniResponseDto() {
    }

    public ConsultarDocumentoPorDniResponseDto(CiudadanoDto ciudadano, PaginaDto page, List<DocumentoDetalleDto> content) {
        this.ciudadano = ciudadano;
        this.page = page;
        this.content = content;
    }

    public CiudadanoDto getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDto ciudadano) {
        this.ciudadano = ciudadano;
    }

    public PaginaDto getPage() {
        return page;
    }

    public void setPage(PaginaDto page) {
        this.page = page;
    }

    public List<DocumentoDetalleDto> getContent() {
        return content;
    }

    public void setContent(List<DocumentoDetalleDto> content) {
        this.content = content;
    }
}
