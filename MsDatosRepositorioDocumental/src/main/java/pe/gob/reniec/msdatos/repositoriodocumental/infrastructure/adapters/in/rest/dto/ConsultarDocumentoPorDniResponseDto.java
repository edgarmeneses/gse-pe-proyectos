package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO Response: Consultar Documentos Por DNI
 */
public class ConsultarDocumentoPorDniResponseDto {
    private final CiudadanoDto ciudadano;
    private final PaginaDto page;
    private final List<DocumentoDetalleDto> content;

    public ConsultarDocumentoPorDniResponseDto(CiudadanoDto ciudadano, PaginaDto page, List<DocumentoDetalleDto> content) {
        this.ciudadano = ciudadano;
        this.page = page;
        this.content = content;
    }

    public CiudadanoDto ciudadano() { return ciudadano; }
    public PaginaDto page() { return page; }
    public List<DocumentoDetalleDto> content() { return content; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultarDocumentoPorDniResponseDto that = (ConsultarDocumentoPorDniResponseDto) o;
        return Objects.equals(ciudadano, that.ciudadano) && Objects.equals(page, that.page) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudadano, page, content);
    }

    @Override
    public String toString() {
        return "ConsultarDocumentoPorDniResponseDto{" +
                "ciudadano=" + ciudadano +
                ", page=" + page +
                ", content=" + content +
                '}';
    }
}
