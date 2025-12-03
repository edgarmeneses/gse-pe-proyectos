package pe.gob.reniec.gse.registradores.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity: Periodo
 * Representa un periodo de asignación de un registrador a una oficina/local.
 * 
 * Reglas de negocio:
 * - Un periodo tiene fecha de inicio y fin
 * - Los periodos no pueden superponerse
 * - Un periodo puede estar activo o cerrado
 */
public class Periodo {
    
    private final String idPeriodo;
    private final String codigoLocal;
    private final String descripcionLocal;
    private final LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoPeriodo estado;
    
    private Periodo(String idPeriodo, String codigoLocal, String descripcionLocal,
                   LocalDateTime fechaInicio, LocalDateTime fechaFin, EstadoPeriodo estado) {
        this.idPeriodo = Objects.requireNonNull(idPeriodo, "ID Periodo es obligatorio");
        this.codigoLocal = Objects.requireNonNull(codigoLocal, "Código local es obligatorio");
        this.descripcionLocal = descripcionLocal;
        this.fechaInicio = Objects.requireNonNull(fechaInicio, "Fecha inicio es obligatoria");
        this.fechaFin = fechaFin;
        this.estado = Objects.requireNonNull(estado, "Estado es obligatorio");
    }
    
    /**
     * Crea un nuevo periodo activo.
     */
    public static Periodo crear(String idPeriodo, String codigoLocal, String descripcionLocal,
                               LocalDateTime fechaInicio) {
        if (fechaInicio.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Fecha de inicio no puede ser futura");
        }
        
        return new Periodo(idPeriodo, codigoLocal, descripcionLocal, fechaInicio, null, EstadoPeriodo.ACTIVO);
    }
    
    /**
     * Reconstruye un periodo desde persistencia.
     */
    public static Periodo reconstruir(String idPeriodo, String codigoLocal, String descripcionLocal,
                                     LocalDateTime fechaInicio, LocalDateTime fechaFin, EstadoPeriodo estado) {
        return new Periodo(idPeriodo, codigoLocal, descripcionLocal, fechaInicio, fechaFin, estado);
    }
    
    /**
     * Cierra el periodo estableciendo una fecha fin.
     */
    public void cerrar(LocalDateTime fechaFin) {
        if (this.estado == EstadoPeriodo.CERRADO) {
            throw new IllegalStateException("El periodo ya está cerrado");
        }
        
        if (fechaFin.isBefore(this.fechaInicio)) {
            throw new IllegalArgumentException("Fecha fin no puede ser anterior a fecha inicio");
        }
        
        this.fechaFin = fechaFin;
        this.estado = EstadoPeriodo.CERRADO;
    }
    
    /**
     * Verifica si este periodo se superpone con otro.
     */
    public boolean seSuperpone(Periodo otro) {
        Objects.requireNonNull(otro, "Periodo a comparar es obligatorio");
        
        // Si este periodo no tiene fecha fin (está abierto), verificar solo con inicio
        if (this.fechaFin == null) {
            // Este periodo está abierto, se superpone si el otro empieza antes de este o no tiene fin
            return otro.fechaFin == null || otro.fechaFin.isAfter(this.fechaInicio);
        }
        
        // Si el otro periodo no tiene fecha fin
        if (otro.fechaFin == null) {
            return otro.fechaInicio.isBefore(this.fechaFin);
        }
        
        // Ambos tienen fecha fin
        return !(this.fechaFin.isBefore(otro.fechaInicio) || otro.fechaFin.isBefore(this.fechaInicio));
    }
    
    /**
     * Verifica si el periodo está actualmente activo.
     */
    public boolean estaActivo() {
        return estado == EstadoPeriodo.ACTIVO && fechaFin == null;
    }
    
    /**
     * Verifica si una fecha cae dentro de este periodo.
     */
    public boolean contieneFecha(LocalDateTime fecha) {
        if (fecha.isBefore(fechaInicio)) {
            return false;
        }
        
        return fechaFin == null || fecha.isBefore(fechaFin);
    }
    
    // Getters
    
    public String getIdPeriodo() {
        return idPeriodo;
    }
    
    public String getCodigoLocal() {
        return codigoLocal;
    }
    
    public String getDescripcionLocal() {
        return descripcionLocal;
    }
    
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    
    public EstadoPeriodo getEstado() {
        return estado;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(idPeriodo, periodo.idPeriodo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idPeriodo);
    }
}
