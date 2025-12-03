package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO Request: Actualizar Carpeta
 */
public class ActualizarCarpetaRequestDto {
    private final String nombre;
    private final String estadoCarpeta;
    private final String parentId;
    private final String descripcion;

    public ActualizarCarpetaRequestDto(String nombre, String estadoCarpeta, String parentId, String descripcion) {
        this.nombre = nombre;
        this.estadoCarpeta = estadoCarpeta;
        this.parentId = parentId;
        this.descripcion = descripcion;
    }

    public String nombre() { return nombre; }
    public String estadoCarpeta() { return estadoCarpeta; }
    public String parentId() { return parentId; }
    public String descripcion() { return descripcion; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActualizarCarpetaRequestDto that = (ActualizarCarpetaRequestDto) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(estadoCarpeta, that.estadoCarpeta) && Objects.equals(parentId, that.parentId) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, estadoCarpeta, parentId, descripcion);
    }

    @Override
    public String toString() {
        return "ActualizarCarpetaRequestDto{" +
                "nombre='" + nombre + '\'' +
                ", estadoCarpeta='" + estadoCarpeta + '\'' +
                ", parentId='" + parentId + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
