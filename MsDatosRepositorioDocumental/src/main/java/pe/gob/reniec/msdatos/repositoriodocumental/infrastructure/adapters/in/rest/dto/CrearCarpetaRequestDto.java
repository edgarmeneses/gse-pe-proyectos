package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO Request: Crear Carpeta
 */
public class CrearCarpetaRequestDto {
    private final String nombre;
    private final String parentId;
    private final String descripcion;

    public CrearCarpetaRequestDto(String nombre, String parentId, String descripcion) {
        this.nombre = nombre;
        this.parentId = parentId;
        this.descripcion = descripcion;
    }

    public String nombre() { return nombre; }
    public String parentId() { return parentId; }
    public String descripcion() { return descripcion; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrearCarpetaRequestDto that = (CrearCarpetaRequestDto) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(parentId, that.parentId) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, parentId, descripcion);
    }

    @Override
    public String toString() {
        return "CrearCarpetaRequestDto{" +
                "nombre='" + nombre + '\'' +
                ", parentId='" + parentId + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
