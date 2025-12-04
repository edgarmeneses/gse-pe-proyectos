package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.Objects;

/**
 * Value Object: Representa el número único de un certificado emitido.
 * Regla de negocio: Debe tener exactamente 10 caracteres.
 */
public class NumeroCertificado {
    private final String valor;
    private static final int LONGITUD_ESPERADA = 10;
    
    private NumeroCertificado(String valor) {
        this.valor = valor;
    }
    
    public static NumeroCertificado de(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de certificado no puede ser nulo o vacío");
        }
        if (valor.length() != LONGITUD_ESPERADA) {
            throw new IllegalArgumentException(
                String.format("El número de certificado debe tener exactamente %d caracteres", LONGITUD_ESPERADA)
            );
        }
        return new NumeroCertificado(valor.trim());
    }
    
    public String getValor() {
        return valor;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumeroCertificado that = (NumeroCertificado) o;
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
