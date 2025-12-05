package pe.gob.reniec.analisisbiometrico.domain.model;

import java.util.List;

/**
 * Value Object: IdentidadEncontradaConFotos
 * Representa una identidad encontrada mediante comparación de fotografías faciales
 */
public class IdentidadEncontradaConFotos {

    private String dni;
    private String nombres;
    private String apellidos;
    private List<String> fotografiasFaciales;

    public IdentidadEncontradaConFotos() {
    }

    public IdentidadEncontradaConFotos(String dni, String nombres, String apellidos,
                                       List<String> fotografiasFaciales) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fotografiasFaciales = fotografiasFaciales;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<String> getFotografiasFaciales() {
        return fotografiasFaciales;
    }

    public void setFotografiasFaciales(List<String> fotografiasFaciales) {
        this.fotografiasFaciales = fotografiasFaciales;
    }
}
