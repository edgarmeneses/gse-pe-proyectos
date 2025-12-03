package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

import java.time.LocalDateTime;

/**
 * Entidad del dominio - Representa un registro individual de ciudadano a cotejar
 */
public class RegistroCotejo {
    
    private Integer secuencia;
    private String numeroDni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private LocalDateTime fechaNacimiento;
    private Genero genero;
    
    public RegistroCotejo() {
    }
    
    public RegistroCotejo(Integer secuencia, String numeroDni, String apellidoPaterno, String apellidoMaterno, 
                          String nombres, LocalDateTime fechaNacimiento, Genero genero) {
        this.secuencia = secuencia;
        this.numeroDni = numeroDni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
    
    public Integer getSecuencia() {
        return secuencia;
    }
    
    public void setSecuencia(Integer secuencia) {
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
    
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Genero getGenero() {
        return genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
