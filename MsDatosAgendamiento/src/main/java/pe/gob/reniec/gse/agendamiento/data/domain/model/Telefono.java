package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class Telefono {
    
    private final String numero;
    
    public Telefono(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (!numero.matches("^\\d{7,15}$")) {
            throw new IllegalArgumentException("El teléfono debe tener entre 7 y 15 dígitos");
        }
        this.numero = numero;
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return numero.equals(telefono.numero);
    }
    
    @Override
    public int hashCode() {
        return numero.hashCode();
    }
    
    @Override
    public String toString() {
        return numero;
    }
}
