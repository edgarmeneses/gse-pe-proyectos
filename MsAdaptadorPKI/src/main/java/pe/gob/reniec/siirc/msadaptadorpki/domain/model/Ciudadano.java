package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Value Object: Representa los datos de identidad de un ciudadano.
 * Encapsula las reglas de negocio relacionadas con la identidad.
 */
public class Ciudadano {
    private final DNI dni;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final String nombres;
    private final LocalDate fechaNacimiento;
    private final TipoDocumento tipoDocumento;
    
    private Ciudadano(DNI dni, String apellidoPaterno, String apellidoMaterno, 
                     String nombres, LocalDate fechaNacimiento, TipoDocumento tipoDocumento) {
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
    }
    
    public static Ciudadano de(String numeroDni, String apellidoPaterno, String apellidoMaterno,
                              String nombres, LocalDate fechaNacimiento, String tipoDoc) {
        if (apellidoPaterno == null || apellidoPaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno es obligatorio");
        }
        if (apellidoMaterno == null || apellidoMaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido materno es obligatorio");
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }
        
        DNI dni = DNI.de(numeroDni);
        TipoDocumento tipo = TipoDocumento.fromString(tipoDoc != null ? tipoDoc : "DNI");
        
        return new Ciudadano(dni, apellidoPaterno.trim(), apellidoMaterno.trim(), 
                            nombres.trim(), fechaNacimiento, tipo);
    }
    
    /**
     * Calcula la edad del ciudadano en años.
     */
    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    /**
     * Obtiene el nombre completo del ciudadano.
     */
    public String getNombreCompleto() {
        return String.format("%s %s %s", nombres, apellidoPaterno, apellidoMaterno);
    }
    
    /**
     * Verifica si el ciudadano es mayor de edad (18 años).
     */
    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }
    
    public DNI getDni() {
        return dni;
    }
    
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    
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
}
