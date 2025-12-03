package pe.gob.reniec.cotejo.masivo.domain.model;

import java.time.LocalDateTime;

public class RegistroEntrada {
    private String registroEntradaId;
    private String ejecucionId;
    private Long numeroSecuencia;
    private String numeroDni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private LocalDateTime fechaNacimiento;
    private String indicadorSexo;
    private String identificadorInstitucion;
    private String datosAdicionales;

    public RegistroEntrada() {
    }

    public RegistroEntrada(String ejecucionId, Long numeroSecuencia, String numeroDni,
                           String apellidoPaterno, String apellidoMaterno, String nombres,
                           LocalDateTime fechaNacimiento, String indicadorSexo,
                           String identificadorInstitucion, String datosAdicionales) {
        this.ejecucionId = ejecucionId;
        this.numeroSecuencia = numeroSecuencia;
        this.numeroDni = numeroDni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.indicadorSexo = indicadorSexo;
        this.identificadorInstitucion = identificadorInstitucion;
        this.datosAdicionales = datosAdicionales;
    }

    public String getRegistroEntradaId() {
        return registroEntradaId;
    }

    public void setRegistroEntradaId(String registroEntradaId) {
        this.registroEntradaId = registroEntradaId;
    }

    public String getEjecucionId() {
        return ejecucionId;
    }

    public void setEjecucionId(String ejecucionId) {
        this.ejecucionId = ejecucionId;
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
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
