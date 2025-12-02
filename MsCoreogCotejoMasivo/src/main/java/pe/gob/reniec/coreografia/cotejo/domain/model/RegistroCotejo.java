package pe.gob.reniec.coreografia.cotejo.domain.model;

import java.time.LocalDate;

public class RegistroCotejo {
    private Long secuencia;
    private String numeroDni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private LocalDate fechaNacimiento;
    private String genero;

    public RegistroCotejo() {
    }

    public RegistroCotejo(Long secuencia, String numeroDni, String apellidoPaterno, String apellidoMaterno, String nombres, LocalDate fechaNacimiento, String genero) {
        this.secuencia = secuencia;
        this.numeroDni = numeroDni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
