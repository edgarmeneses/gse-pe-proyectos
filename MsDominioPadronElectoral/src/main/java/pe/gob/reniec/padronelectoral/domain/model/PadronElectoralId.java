package pe.gob.reniec.padronelectoral.domain.model;

import java.util.Objects;

/**
 * Value Object: ID de Padrón Electoral
 * Encapsula el identificador único de un padrón electoral.
 */
public class PadronElectoralId {
    private final String valor;

    public PadronElectoralId(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del padrón no puede ser nulo o vacío");
        }
        this.valor = valor.trim();
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PadronElectoralId that = (PadronElectoralId) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}
