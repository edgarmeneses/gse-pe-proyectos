package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Registro de Cotejo
 */
public class RegistroCotejoDto {
    
    private Integer secuencia;
    private String numeroDni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String fechaNacimiento;
    private String genero;
    
    public RegistroCotejoDto() {
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
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
