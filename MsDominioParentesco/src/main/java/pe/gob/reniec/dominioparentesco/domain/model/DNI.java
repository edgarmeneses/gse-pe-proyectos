package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Value Object - Representa un DNI (Documento Nacional de Identidad).
 * Encapsula las reglas de validación del DNI peruano.
 */
public class DNI {
    
    private static final Pattern DNI_PATTERN = Pattern.compile("^\\d{8}$");
    private final String valor;
    
    private DNI(String valor) {
        this.valor = valor;
    }
    
    public static DNI of(String valor) {
        validar(valor);
        return new DNI(valor);
    }
    
    private static void validar(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }
        
        String dniLimpio = valor.trim();
        if (!DNI_PATTERN.matcher(dniLimpio).matches()) {
            throw new IllegalArgumentException("DNI inválido: debe contener exactamente 8 dígitos");
        }
    }
    
    public String valor() {
        return valor;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNI dni = (DNI) o;
        return Objects.equals(valor, dni.valor);
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
