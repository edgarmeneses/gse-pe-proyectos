package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public class RegistroEntradaDto {
    private Long numeroSecuencia;
    private String numeroDni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String fechaNacimiento;
    private String indicadorSexo;
    private String identificadorInstitucion;
    private String datosAdicionales;

    public RegistroEntradaDto() {
    }

    public Long getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(Long numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
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

    public String getIndicadorSexo() {
        return indicadorSexo;
    }

    public void setIndicadorSexo(String indicadorSexo) {
        this.indicadorSexo = indicadorSexo;
    }

    public String getIdentificadorInstitucion() {
        return identificadorInstitucion;
    }

    public void setIdentificadorInstitucion(String identificadorInstitucion) {
        this.identificadorInstitucion = identificadorInstitucion;
    }

    public String getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(String datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }
}
