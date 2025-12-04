package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Value Object: Representa el número de DNI de un ciudadano peruano.
 * Regla de negocio: Debe tener exactamente 8 dígitos numéricos.
 */
public class DNI {
    private final String numero;
    private static final Pattern PATRON_DNI = Pattern.compile("^\\d{8}$");
    private static final int LONGITUD_DNI = 8;
    
    private DNI(String numero) {
        this.numero = numero;
    }
    
    public static DNI de(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }
        
        String dniLimpio = numero.trim();
        
        if (!PATRON_DNI.matcher(dniLimpio).matches()) {
            throw new IllegalArgumentException(
                String.format("El DNI debe contener exactamente %d dígitos numéricos", LONGITUD_DNI)
            );
        }
        
        return new DNI(dniLimpio);
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNI dni = (DNI) o;
        return Objects.equals(numero, dni.numero);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
    
    @Override
    public String toString() {
        return numero;
    }
}
