package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Entidad Solicitante en la respuesta (solo código y nombre)
 */
public class EntidadSolicitanteResponseDto {
    
    private String codigo;
    private String nombre;
    
    public EntidadSolicitanteResponseDto() {
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
