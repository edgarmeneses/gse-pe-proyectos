package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Oficina donde se registró la solicitud
 */
public class OficinaRegistro {
    
    private String codigo;
    private String nombre;
    
    public OficinaRegistro() {
    }
    
    public OficinaRegistro(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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
}
