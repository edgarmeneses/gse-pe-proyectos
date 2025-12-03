package pe.gob.reniec.gse.registradores.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object: Firma
 * Representa la firma registrada de un registrador civil.
 * 
 * Reglas de negocio:
 * - Una firma debe tener un hash único
 * - Una vez registrada, puede ser actualizada
 * - Guarda la fecha de última actualización
 */
public class Firma {
    
    private final String hashFirma;
    private final LocalDateTime fechaRegistro;
    
    private Firma(String hashFirma, LocalDateTime fechaRegistro) {
        this.hashFirma = Objects.requireNonNull(hashFirma, "Hash de firma es obligatorio");
        this.fechaRegistro = Objects.requireNonNull(fechaRegistro, "Fecha de registro es obligatoria");
        
        if (hashFirma.trim().isEmpty()) {
            throw new IllegalArgumentException("Hash de firma no puede estar vacío");
        }
    }
    
    /**
     * Crea una nueva firma.
     */
    public static Firma crear(String hashFirma) {
        return new Firma(hashFirma, LocalDateTime.now());
    }
    
    /**
     * Reconstruye una firma desde persistencia.
     */
    public static Firma reconstruir(String hashFirma, LocalDateTime fechaRegistro) {
        return new Firma(hashFirma, fechaRegistro);
    }
    
    /**
     * Crea una nueva instancia con un hash actualizado.
     */
    public Firma actualizar(String nuevoHashFirma) {
        return new Firma(nuevoHashFirma, LocalDateTime.now());
    }
    
    /**
     * Verifica si la firma está registrada (siempre true si existe la instancia).
     */
    public boolean estaRegistrada() {
        return hashFirma != null && !hashFirma.trim().isEmpty();
    }
    
    // Getters
    
    public String getHashFirma() {
        return hashFirma;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firma firma = (Firma) o;
        return Objects.equals(hashFirma, firma.hashFirma);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(hashFirma);
    }
    
    @Override
    public String toString() {
        return "Firma{" +
                "hash='" + (hashFirma != null ? hashFirma.substring(0, Math.min(10, hashFirma.length())) + "..." : "null") + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
