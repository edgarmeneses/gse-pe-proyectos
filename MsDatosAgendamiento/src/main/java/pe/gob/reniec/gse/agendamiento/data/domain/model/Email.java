package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class Email {
    
    private final String direccion;
    
    public Email(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!direccion.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("El formato del email no es válido");
        }
        this.direccion = direccion.toLowerCase();
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return direccion.equals(email.direccion);
    }
    
    @Override
    public int hashCode() {
        return direccion.hashCode();
    }
    
    @Override
    public String toString() {
        return direccion;
    }
}
