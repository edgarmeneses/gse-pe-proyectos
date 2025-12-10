package pe.gob.reniec.padronelectoral.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Value Object: Número de Documento de Identidad
 * Encapsula y valida el número de documento de un ciudadano.
 */
public class NumeroDocumento {
    private static final Pattern DNI_PATTERN = Pattern.compile("^\\d{8}$");
    private static final Pattern CE_PATTERN = Pattern.compile("^\\d{9}$");
    
    private final String valor;

    public NumeroDocumento(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de documento no puede ser nulo o vacío");
        }
        
        String valorLimpio = valor.trim();
        
        if (!DNI_PATTERN.matcher(valorLimpio).matches() && 
            !CE_PATTERN.matcher(valorLimpio).matches()) {
            throw new IllegalArgumentException("Número de documento inválido. Debe ser DNI (8 dígitos) o CE (9 dígitos)");
        }
        
        this.valor = valorLimpio;
    }

    public String getValor() {
        return valor;
    }

    public boolean esDNI() {
        return valor.length() == 8;
    }

    public boolean esCarnetExtranjeria() {
        return valor.length() == 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumeroDocumento that = (NumeroDocumento) o;
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
