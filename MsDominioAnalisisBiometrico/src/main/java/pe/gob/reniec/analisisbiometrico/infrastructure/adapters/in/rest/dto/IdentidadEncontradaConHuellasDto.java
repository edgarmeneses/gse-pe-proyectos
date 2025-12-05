package pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para identidad encontrada mediante huellas dactilares
 */
public class IdentidadEncontradaConHuellasDto {

    private String dni;
    private String nombres;
    private String apellidos;
    private List<String> huellasDactilares;

    public IdentidadEncontradaConHuellasDto() {
    }

    public IdentidadEncontradaConHuellasDto(String dni, String nombres, String apellidos,
                                           List<String> huellasDactilares) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.huellasDactilares = huellasDactilares;
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

    public List<String> getHuellasDactilares() {
        return huellasDactilares;
    }

    public void setHuellasDactilares(List<String> huellasDactilares) {
        this.huellasDactilares = huellasDactilares;
    }
}
