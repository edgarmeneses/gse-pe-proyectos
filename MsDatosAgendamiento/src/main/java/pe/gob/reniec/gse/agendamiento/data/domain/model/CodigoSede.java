package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class CodigoSede {
    
    private final String codigo;
    
    public CodigoSede(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de sede no puede estar vacío");
        }
        this.codigo = codigo.trim().toUpperCase();
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoSede that = (CodigoSede) o;
        return codigo.equals(that.codigo);
    }
    
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
    
    @Override
    public String toString() {
        return codigo;
    }
}
