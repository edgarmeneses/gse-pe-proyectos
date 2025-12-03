package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class Dni {
    
    private final String numero;
    
    public Dni(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
        if (!numero.matches("^\\d{8}$")) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos numéricos");
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
        Dni dni = (Dni) o;
        return numero.equals(dni.numero);
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
