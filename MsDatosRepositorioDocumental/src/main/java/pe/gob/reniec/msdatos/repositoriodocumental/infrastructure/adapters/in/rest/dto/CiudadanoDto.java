package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO: Información de ciudadano
 */
public class CiudadanoDto {
    private final String dni;
    private final String nombreCompleto;

    public CiudadanoDto(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }

    public String dni() { return dni; }
    public String nombreCompleto() { return nombreCompleto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiudadanoDto that = (CiudadanoDto) o;
        return Objects.equals(dni, that.dni) && Objects.equals(nombreCompleto, that.nombreCompleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombreCompleto);
    }

    @Override
    public String toString() {
        return "CiudadanoDto{" +
                "dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
