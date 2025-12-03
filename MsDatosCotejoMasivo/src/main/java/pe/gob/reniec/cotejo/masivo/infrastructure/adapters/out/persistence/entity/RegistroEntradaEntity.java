package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class RegistroEntradaEntity {
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
    private LocalDateTime fechaCreacion;

    public RegistroEntradaEntity() {
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
