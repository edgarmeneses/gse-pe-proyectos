package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Links HATEOAS
 */
public class LinksDto {
    private String self;
    private String firmas;
    private String sellos;
    private String periodos;
    private String asignaciones;

    public LinksDto() {
    }

    public LinksDto(String self, String firmas, String sellos, String periodos, String asignaciones) {
        this.self = self;
        this.firmas = firmas;
        this.sellos = sellos;
        this.periodos = periodos;
        this.asignaciones = asignaciones;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getFirmas() {
        return firmas;
    }

    public void setFirmas(String firmas) {
        this.firmas = firmas;
    }

    public String getSellos() {
        return sellos;
    }

    public void setSellos(String sellos) {
        this.sellos = sellos;
    }

    public String getPeriodos() {
        return periodos;
    }

    public void setPeriodos(String periodos) {
        this.periodos = periodos;
    }

    public String getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(String asignaciones) {
        this.asignaciones = asignaciones;
    }
}
