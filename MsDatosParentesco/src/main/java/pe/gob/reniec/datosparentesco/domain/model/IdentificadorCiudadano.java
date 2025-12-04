package pe.gob.reniec.datosparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object inmutable que representa un identificador de ciudadano (DNI).
 * Encapsula las reglas de validación del DNI.
 */
public final class IdentificadorCiudadano {
    
    private static final int LONGITUD_MINIMA = 8;
    private static final int LONGITUD_MAXIMA = 12;
    
    private final String valor;
    
    private IdentificadorCiudadano(String valor) {
        this.valor = valor;
    }
    
    /**
     * Factory method que valida y crea un identificador de ciudadano.
     */
    public static IdentificadorCiudadano of(String valor) {
        validar(valor);
        return new IdentificadorCiudadano(valor);
    }
    
    private static void validar(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El identificador de ciudadano no puede ser nulo o vacío");
        }
        
        String valorLimpio = valor.trim();
        if (valorLimpio.length() < LONGITUD_MINIMA || valorLimpio.length() > LONGITUD_MAXIMA) {
            throw new IllegalArgumentException(
                String.format("El identificador debe tener entre %d y %d caracteres", LONGITUD_MINIMA, LONGITUD_MAXIMA)
            );
        }
    }
    
    public String getValor() {
        return valor;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificadorCiudadano that = (IdentificadorCiudadano) o;
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
