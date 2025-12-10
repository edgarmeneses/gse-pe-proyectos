package pe.gob.reniec.padronelectoral.domain.model;

import java.util.Objects;

/**
 * Value Object: Circunscripción Electoral
 * Representa la ubicación geográfica del padrón electoral.
 * Inmutable y con lógica de negocio.
 */
public class Circunscripcion {
    private final String departamento;
    private final String provincia;
    private final String distrito;

    public Circunscripcion(String departamento, String provincia, String distrito) {
        this.departamento = validarCampo(departamento, "Departamento");
        this.provincia = validarCampo(provincia, "Provincia");
        this.distrito = validarCampo(distrito, "Distrito");
    }

    private String validarCampo(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(nombreCampo + " no puede ser nulo o vacío");
        }
        if (valor.length() > 50) {
            throw new IllegalArgumentException(nombreCampo + " excede la longitud máxima de 50 caracteres");
        }
        return valor.trim().toUpperCase();
    }

    // Método de dominio: Verificar coincidencia
    public boolean coincideCon(String departamento, String provincia, String distrito) {
        return this.departamento.equalsIgnoreCase(departamento) &&
               this.provincia.equalsIgnoreCase(provincia) &&
               this.distrito.equalsIgnoreCase(distrito);
    }

    // Método de dominio: Obtener representación completa
    public String obtenerUbicacionCompleta() {
        return departamento + " - " + provincia + " - " + distrito;
    }

    // Método de dominio: Verificar si es región capital
    public boolean esCapital() {
        return "LIMA".equalsIgnoreCase(departamento) && 
               "LIMA".equalsIgnoreCase(provincia) &&
               "LIMA".equalsIgnoreCase(distrito);
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circunscripcion that = (Circunscripcion) o;
        return departamento.equalsIgnoreCase(that.departamento) &&
               provincia.equalsIgnoreCase(that.provincia) &&
               distrito.equalsIgnoreCase(that.distrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamento.toUpperCase(), provincia.toUpperCase(), distrito.toUpperCase());
    }

    @Override
    public String toString() {
        return obtenerUbicacionCompleta();
    }
}
