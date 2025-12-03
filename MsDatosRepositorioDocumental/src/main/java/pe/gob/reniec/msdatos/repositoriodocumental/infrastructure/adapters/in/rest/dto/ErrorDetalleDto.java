package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO: Detalle de error individual
 */
public class ErrorDetalleDto {
    private final String detalleError;

    public ErrorDetalleDto(String detalleError) {
        this.detalleError = detalleError;
    }

    public String detalleError() { return detalleError; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDetalleDto that = (ErrorDetalleDto) o;
        return Objects.equals(detalleError, that.detalleError);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detalleError);
    }

    @Override
    public String toString() {
        return "ErrorDetalleDto{" +
                "detalleError='" + detalleError + '\'' +
                '}';
    }
}
