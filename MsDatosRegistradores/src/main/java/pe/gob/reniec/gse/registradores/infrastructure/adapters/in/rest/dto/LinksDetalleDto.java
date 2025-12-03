package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Links Detalle HATEOAS
 */
public class LinksDetalleDto {
    private String self;
    private String firmas;
    private String sellos;
    private String periodos;
    private String asignaciones;
    private String historialFirmas;
    private String historialSellos;

    public LinksDetalleDto() {
    }

    public LinksDetalleDto(String self, String firmas, String sellos, String periodos, 
                          String asignaciones, String historialFirmas, String historialSellos) {
        this.self = self;
        this.firmas = firmas;
        this.sellos = sellos;
        this.periodos = periodos;
        this.asignaciones = asignaciones;
        this.historialFirmas = historialFirmas;
        this.historialSellos = historialSellos;
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

    public String getHistorialFirmas() {
        return historialFirmas;
    }

    public void setHistorialFirmas(String historialFirmas) {
        this.historialFirmas = historialFirmas;
    }

    public String getHistorialSellos() {
        return historialSellos;
    }

    public void setHistorialSellos(String historialSellos) {
        this.historialSellos = historialSellos;
    }
}
