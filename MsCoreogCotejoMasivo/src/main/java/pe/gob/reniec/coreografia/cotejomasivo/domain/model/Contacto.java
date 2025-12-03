package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Información de contacto de la entidad solicitante
 */
public class Contacto {
    
    private String email;
    private String telefono;
    
    public Contacto() {
    }
    
    public Contacto(String email, String telefono) {
        this.email = email;
        this.telefono = telefono;
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
