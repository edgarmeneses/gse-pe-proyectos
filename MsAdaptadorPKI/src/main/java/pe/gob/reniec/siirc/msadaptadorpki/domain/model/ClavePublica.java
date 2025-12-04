package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.Base64;
import java.util.Objects;

/**
 * Value Object: Representa una clave pública en formato Base64.
 * Encapsula la validación y manejo de claves criptográficas.
 */
public class ClavePublica {
    private final String valor;
    
    private ClavePublica(String valor) {
        this.valor = valor;
    }
    
    public static ClavePublica de(String valorBase64) {
        if (valorBase64 == null || valorBase64.trim().isEmpty()) {
            throw new IllegalArgumentException("La clave pública no puede ser nula o vacía");
        }
        
        // Validar que sea Base64 válido
        try {
            Base64.getDecoder().decode(valorBase64.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("La clave pública debe estar en formato Base64 válido", e);
        }
        
        return new ClavePublica(valorBase64.trim());
    }
    
    public String getValor() {
        return valor;
    }
    
    /**
     * Obtiene los bytes decodificados de la clave pública.
     */
    public byte[] getBytes() {
        return Base64.getDecoder().decode(valor);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClavePublica that = (ClavePublica) o;
        return Objects.equals(valor, that.valor);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
    
    @Override
    public String toString() {
        // No exponer la clave completa en toString por seguridad
        return "ClavePublica{***}";
    }
}
