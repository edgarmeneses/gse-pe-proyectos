package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Entidad Solicitante
 */
public class EntidadSolicitanteDto {
    
    private String codigo;
    private String nombre;
    private String ruc;
    private RepresentanteLegalDto representanteLegal;
    private ContactoDto contacto;
    
    public EntidadSolicitanteDto() {
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRuc() {
        return ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public RepresentanteLegalDto getRepresentanteLegal() {
        return representanteLegal;
    }
    
    public void setRepresentanteLegal(RepresentanteLegalDto representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    
    public ContactoDto getContacto() {
        return contacto;
    }
    
    public void setContacto(ContactoDto contacto) {
        this.contacto = contacto;
    }
}
