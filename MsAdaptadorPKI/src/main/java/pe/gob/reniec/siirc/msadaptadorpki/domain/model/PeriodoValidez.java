package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Value Object: Representa el período de validez de un certificado.
 * Encapsula las reglas de negocio relacionadas con fechas de validez.
 */
public class PeriodoValidez {
    private final LocalDateTime fechaEmision;
    private final LocalDateTime fechaExpiracion;
    
    public PeriodoValidez(LocalDateTime fechaEmision, LocalDateTime fechaExpiracion) {
        if (fechaEmision == null) {
            throw new IllegalArgumentException("La fecha de emisión no puede ser nula");
        }
        if (fechaExpiracion == null) {
            throw new IllegalArgumentException("La fecha de expiración no puede ser nula");
        }
        if (fechaExpiracion.isBefore(fechaEmision)) {
            throw new IllegalArgumentException("La fecha de expiración debe ser posterior a la fecha de emisión");
        }
        
        this.fechaEmision = fechaEmision;
        this.fechaExpiracion = fechaExpiracion;
    }
    
    /**
     * Verifica si el período está actualmente vigente.
     */
    public boolean estaVigente() {
        LocalDateTime ahora = LocalDateTime.now();
        return !ahora.isBefore(fechaEmision) && !ahora.isAfter(fechaExpiracion);
    }
    
    /**
     * Verifica si el período ha expirado.
     */
    public boolean haExpirado() {
        return LocalDateTime.now().isAfter(fechaExpiracion);
    }
    
    /**
     * Calcula los días restantes hasta la expiración.
     * Retorna 0 si ya expiró, o valor negativo si aún no inicia.
     */
    public long diasRestantes() {
        LocalDateTime ahora = LocalDateTime.now();
        if (ahora.isAfter(fechaExpiracion)) {
            return 0;
        }
        return ChronoUnit.DAYS.between(ahora, fechaExpiracion);
    }
    
    /**
     * Calcula la duración total del período en días.
     */
    public long duracionEnDias() {
        return ChronoUnit.DAYS.between(fechaEmision, fechaExpiracion);
    }
    
    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }
    
    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoValidez that = (PeriodoValidez) o;
        return Objects.equals(fechaEmision, that.fechaEmision) &&
               Objects.equals(fechaExpiracion, that.fechaExpiracion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fechaEmision, fechaExpiracion);
    }
}
