package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class NombreCompleto {
    
    private final String nombres;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    
    public NombreCompleto(String nombres, String apellidoPaterno, String apellidoMaterno) {
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("Los nombres no pueden estar vacíos");
        }
        if (apellidoPaterno == null || apellidoPaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío");
        }
        this.nombres = nombres.trim();
        this.apellidoPaterno = apellidoPaterno.trim();
        this.apellidoMaterno = apellidoMaterno != null ? apellidoMaterno.trim() : "";
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
    public String getNombreCompletoFormateado() {
        if (apellidoMaterno.isEmpty()) {
            return apellidoPaterno + " " + nombres;
        }
        return apellidoPaterno + " " + apellidoMaterno + " " + nombres;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto that = (NombreCompleto) o;
        return nombres.equals(that.nombres) && 
               apellidoPaterno.equals(that.apellidoPaterno) && 
               apellidoMaterno.equals(that.apellidoMaterno);
    }
    
    @Override
    public int hashCode() {
        int result = nombres.hashCode();
        result = 31 * result + apellidoPaterno.hashCode();
        result = 31 * result + apellidoMaterno.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        return getNombreCompletoFormateado();
    }
}
