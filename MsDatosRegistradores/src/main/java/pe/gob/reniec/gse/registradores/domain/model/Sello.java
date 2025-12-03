package pe.gob.reniec.gse.registradores.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object: Sello
 * Representa el sello registrado de un registrador civil.
 * 
 * Reglas de negocio:
 * - Un sello debe tener un hash único
 * - Una vez registrado, puede ser actualizado
 * - Guarda la fecha de última actualización
 */
public class Sello {
    
    private final String hashSello;
    private final LocalDateTime fechaRegistro;
    
    private Sello(String hashSello, LocalDateTime fechaRegistro) {
        this.hashSello = Objects.requireNonNull(hashSello, "Hash de sello es obligatorio");
        this.fechaRegistro = Objects.requireNonNull(fechaRegistro, "Fecha de registro es obligatoria");
        
        if (hashSello.trim().isEmpty()) {
            throw new IllegalArgumentException("Hash de sello no puede estar vacío");
        }
    }
    
    /**
     * Crea un nuevo sello.
     */
    public static Sello crear(String hashSello) {
        return new Sello(hashSello, LocalDateTime.now());
    }
    
    /**
     * Reconstruye un sello desde persistencia.
     */
    public static Sello reconstruir(String hashSello, LocalDateTime fechaRegistro) {
        return new Sello(hashSello, fechaRegistro);
    }
    
    /**
     * Crea una nueva instancia con un hash actualizado.
     */
    public Sello actualizar(String nuevoHashSello) {
        return new Sello(nuevoHashSello, LocalDateTime.now());
    }
    
    /**
     * Verifica si el sello está registrado (siempre true si existe la instancia).
     */
    public boolean estaRegistrado() {
        return hashSello != null && !hashSello.trim().isEmpty();
    }
    
    // Getters
    
    public String getHashSello() {
        return hashSello;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sello sello = (Sello) o;
        return Objects.equals(hashSello, sello.hashSello);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(hashSello);
    }
    
    @Override
    public String toString() {
        return "Sello{" +
                "hash='" + (hashSello != null ? hashSello.substring(0, Math.min(10, hashSello.length())) + "..." : "null") + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
