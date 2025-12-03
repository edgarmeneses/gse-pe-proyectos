package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Contacto
 */
public class ContactoDto {
    
    private String email;
    private String telefono;
    
    public ContactoDto() {
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
