package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO: Respuesta de error estándar
 */
public class ErrorDto {
    private final String tipo;
    private final String titulo;
    private final Integer estado;
    private final List<ErrorDetalleDto> errores;

    public ErrorDto(String tipo, String titulo, Integer estado, List<ErrorDetalleDto> errores) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.estado = estado;
        this.errores = errores;
    }

    public String tipo() { return tipo; }
    public String titulo() { return titulo; }
    public Integer estado() { return estado; }
    public List<ErrorDetalleDto> errores() { return errores; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDto errorDto = (ErrorDto) o;
        return Objects.equals(tipo, errorDto.tipo) && Objects.equals(titulo, errorDto.titulo) && Objects.equals(estado, errorDto.estado) && Objects.equals(errores, errorDto.errores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, titulo, estado, errores);
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "tipo='" + tipo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", estado=" + estado +
                ", errores=" + errores +
                '}';
    }
}
