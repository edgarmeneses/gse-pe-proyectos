package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Value Object: Representa una dirección de email válida.
 * Encapsula la validación de formato de email según RFC 5322.
 */
public class Email {
    private final String valor;
    private static final Pattern PATRON_EMAIL = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );
    
    private Email(String valor) {
        this.valor = valor;
    }
    
    public static Email de(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        
        String emailLimpio = email.trim().toLowerCase();
        
        if (!PATRON_EMAIL.matcher(emailLimpio).matches()) {
            throw new IllegalArgumentException("El formato del email es inválido: " + email);
        }
        
        return new Email(emailLimpio);
    }
    
    public String getValor() {
        return valor;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(valor, email.valor);
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
