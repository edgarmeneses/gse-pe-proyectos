package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Oficina registral de RENIEC
 */
public class OficinaRegistralDto {

    private String codigo;
    private String nombre;

    public OficinaRegistralDto() {
    }

    public OficinaRegistralDto(String codigo, String nombre) {
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
