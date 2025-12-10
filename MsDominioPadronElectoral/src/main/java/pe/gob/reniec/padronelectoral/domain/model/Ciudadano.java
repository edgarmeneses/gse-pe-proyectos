package pe.gob.reniec.padronelectoral.domain.model;

import java.util.Objects;

/**
 * Value Object: Ciudadano
 * Representa un ciudadano habilitado para votar en un padrón electoral.
 * Inmutable y con validaciones de dominio.
 */
public class Ciudadano {
    private final String nombre;
    private final NumeroDocumento documento;
    private final String direccion;

    public Ciudadano(String nombre, String documento, String direccion) {
        this.nombre = validarNombre(nombre);
        this.documento = new NumeroDocumento(documento);
        this.direccion = validarDireccion(direccion);
    }

    // Constructor con NumeroDocumento ya creado
    public Ciudadano(String nombre, NumeroDocumento documento, String direccion) {
        this.nombre = validarNombre(nombre);
        this.documento = Objects.requireNonNull(documento, "El documento no puede ser nulo");
        this.direccion = validarDireccion(direccion);
    }

    private String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del ciudadano no puede ser nulo o vacío");
        }
        if (nombre.length() > 200) {
            throw new IllegalArgumentException("El nombre excede la longitud máxima de 200 caracteres");
        }
        return nombre.trim().toUpperCase();
    }

    private String validarDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección del ciudadano no puede ser nula o vacía");
        }
        if (direccion.length() > 300) {
            throw new IllegalArgumentException("La dirección excede la longitud máxima de 300 caracteres");
        }
        return direccion.trim();
    }

    // Método de dominio: Verificar si tiene DNI o Carnet de Extranjería
    public boolean tieneDNI() {
        return documento.esDNI();
    }

    public boolean tieneCarnetExtranjeria() {
        return documento.esCarnetExtranjeria();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento.getValor();
    }

    public NumeroDocumento getDocumentoCompleto() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return Objects.equals(documento, ciudadano.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "nombre='" + nombre + '\'' +
                ", documento=" + documento +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
