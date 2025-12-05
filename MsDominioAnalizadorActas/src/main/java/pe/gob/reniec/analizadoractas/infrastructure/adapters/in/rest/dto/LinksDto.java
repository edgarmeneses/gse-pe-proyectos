package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Hipervínculos HATEOAS
 */
public class LinksDto {

    private String self;
    private String exportar;
    private String actas;

    public LinksDto() {
    }

    public LinksDto(String self, String exportar, String actas) {
        this.self = self;
        this.exportar = exportar;
        this.actas = actas;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getExportar() {
        return exportar;
    }

    public void setExportar(String exportar) {
        this.exportar = exportar;
    }

    public String getActas() {
        return actas;
    }

    public void setActas(String actas) {
        this.actas = actas;
    }
}
