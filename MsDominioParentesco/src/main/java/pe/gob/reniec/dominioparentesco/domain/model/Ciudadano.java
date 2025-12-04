package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity - Representa un ciudadano en el dominio de parentesco.
 * No es un aggregate root, forma parte de AnalisisParentesco.
 */
public class Ciudadano {
    
    private final DNI dni;
    private final String nombreCompleto;
    private final LocalDateTime fechaNacimiento;
    
    private Ciudadano(DNI dni, String nombreCompleto, LocalDateTime fechaNacimiento) {
        this.dni = Objects.requireNonNull(dni, "El DNI no puede ser nulo");
        this.nombreCompleto = validarNombre(nombreCompleto);
        this.fechaNacimiento = validarFechaNacimiento(fechaNacimiento);
    }
    
    public static Ciudadano crear(String dni, String nombreCompleto, LocalDateTime fechaNacimiento) {
        return new Ciudadano(DNI.of(dni), nombreCompleto, fechaNacimiento);
    }
    
    public static Ciudadano crear(DNI dni, String nombreCompleto, LocalDateTime fechaNacimiento) {
        return new Ciudadano(dni, nombreCompleto, fechaNacimiento);
    }
    
    private String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        if (nombre.length() > 200) {
            throw new IllegalArgumentException("El nombre no puede exceder 200 caracteres");
        }
        return nombre.trim();
    }
    
    private LocalDateTime validarFechaNacimiento(LocalDateTime fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        if (fecha.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }
        if (fecha.isBefore(LocalDateTime.of(1900, 1, 1, 0, 0))) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser anterior a 1900");
        }
        return fecha;
    }
    
    public int calcularEdad() {
        return LocalDateTime.now().getYear() - fechaNacimiento.getYear();
    }
    
    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }
    
    // Getters
    public DNI getDni() { return dni; }
    public String getNombreCompleto() { return nombreCompleto; }
    public LocalDateTime getFechaNacimiento() { return fechaNacimiento; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return Objects.equals(dni, ciudadano.dni);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    
    @Override
    public String toString() {
        return nombreCompleto + " (" + dni + ")";
    }
}
