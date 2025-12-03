package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Request: Crear Carpeta
 */
public class CrearCarpetaRequestDto {
    private String nombre;
    private String parentId;
    private String descripcion;

    public CrearCarpetaRequestDto() {
    }

    public CrearCarpetaRequestDto(String nombre, String parentId, String descripcion) {
        this.nombre = nombre;
        this.parentId = parentId;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
