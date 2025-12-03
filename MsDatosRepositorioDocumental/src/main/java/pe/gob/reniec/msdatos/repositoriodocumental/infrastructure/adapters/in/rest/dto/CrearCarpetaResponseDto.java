package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO Response: Crear Carpeta
 */
public class CrearCarpetaResponseDto {
    private final String id;
    private final String createdAt;
    private final String estadoCarpeta;
    private final String ruta;

    public CrearCarpetaResponseDto(String id, String createdAt, String estadoCarpeta, String ruta) {
        this.id = id;
        this.createdAt = createdAt;
        this.estadoCarpeta = estadoCarpeta;
        this.ruta = ruta;
    }

    public String id() { return id; }
    public String createdAt() { return createdAt; }
    public String estadoCarpeta() { return estadoCarpeta; }
    public String ruta() { return ruta; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrearCarpetaResponseDto that = (CrearCarpetaResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(estadoCarpeta, that.estadoCarpeta) && Objects.equals(ruta, that.ruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, estadoCarpeta, ruta);
    }

    @Override
    public String toString() {
        return "CrearCarpetaResponseDto{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", estadoCarpeta='" + estadoCarpeta + '\'' +
                ", ruta='" + ruta + '\'' +
                '}';
    }
}
