package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class Solicitante {
    
    private final Dni dni;
    private final NombreCompleto nombreCompleto;
    private final Email email;
    private final Telefono telefono;
    
    public Solicitante(Dni dni, NombreCompleto nombreCompleto, Email email, Telefono telefono) {
        if (dni == null) {
            throw new IllegalArgumentException("El DNI del solicitante es requerido");
        }
        if (nombreCompleto == null) {
            throw new IllegalArgumentException("El nombre completo del solicitante es requerido");
        }
        if (email == null) {
            throw new IllegalArgumentException("El email del solicitante es requerido");
        }
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Dni getDni() {
        return dni;
    }
    
    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
    
    public Email getEmail() {
        return email;
    }
    
    public Telefono getTelefono() {
        return telefono;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitante that = (Solicitante) o;
        return dni.equals(that.dni);
    }
    
    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
