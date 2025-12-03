package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Request: Actualizar Carpeta
 */
public class ActualizarCarpetaRequestDto {
    private String nombre;
    private String estadoCarpeta;
    private String parentId;
    private String descripcion;

    public ActualizarCarpetaRequestDto() {
    }

    public ActualizarCarpetaRequestDto(String nombre, String estadoCarpeta, String parentId, String descripcion) {
        this.nombre = nombre;
        this.estadoCarpeta = estadoCarpeta;
        this.parentId = parentId;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCarpeta() {
        return estadoCarpeta;
    }

    public void setEstadoCarpeta(String estadoCarpeta) {
        this.estadoCarpeta = estadoCarpeta;
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
