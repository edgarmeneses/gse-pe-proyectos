package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Links HATEOAS
 */
public class LinksDto {
    
    private String self;
    private String consultarEstado;
    private String cancelar;
    
    public LinksDto() {
    }
    
    public String getSelf() {
        return self;
    }
    
    public void setSelf(String self) {
        this.self = self;
    }
    
    public String getConsultarEstado() {
        return consultarEstado;
    }
    
    public void setConsultarEstado(String consultarEstado) {
        this.consultarEstado = consultarEstado;
    }
    
    public String getCancelar() {
        return cancelar;
    }
    
    public void setCancelar(String cancelar) {
        this.cancelar = cancelar;
    }
}
