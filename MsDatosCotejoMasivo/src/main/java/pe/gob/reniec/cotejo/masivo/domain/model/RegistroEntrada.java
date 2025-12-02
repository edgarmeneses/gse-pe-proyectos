package pe.gob.reniec.cotejo.masivo.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class RegistroEntrada {
    private UUID registroEntradaId;
    private UUID ejecucionId;
    private Integer numeroSecuencia;
    private String numeroDni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private LocalDate fechaNacimiento;
    private String indicadorSexo;
    private String identificadorInstitucion;
    private String datosAdicionales;

    public RegistroEntrada() {
    }

    public UUID getRegistroEntradaId() {
        return registroEntradaId;
    }

    public void setRegistroEntradaId(UUID registroEntradaId) {
        this.registroEntradaId = registroEntradaId;
    }

    public UUID getEjecucionId() {
        return ejecucionId;
    }

    public void setEjecucionId(UUID ejecucionId) {
        this.ejecucionId = ejecucionId;
    }

    public Integer getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(Integer numeroSecuencia) {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
