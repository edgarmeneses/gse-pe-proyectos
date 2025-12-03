package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class SedeServicio {
    
    private final CodigoSede codigoSede;
    private final String nombre;
    private final String direccion;
    
    public SedeServicio(CodigoSede codigoSede, String nombre, String direccion) {
        if (codigoSede == null) {
            throw new IllegalArgumentException("El código de sede es requerido");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sede es requerido");
        }
        this.codigoSede = codigoSede;
        this.nombre = nombre.trim();
        this.direccion = direccion != null ? direccion.trim() : "";
    }
    
    public CodigoSede getCodigoSede() {
        return codigoSede;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SedeServicio that = (SedeServicio) o;
        return codigoSede.equals(that.codigoSede);
    }
    
    @Override
    public int hashCode() {
        return codigoSede.hashCode();
    }
}
