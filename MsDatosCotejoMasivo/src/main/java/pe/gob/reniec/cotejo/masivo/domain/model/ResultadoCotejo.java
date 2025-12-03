package pe.gob.reniec.cotejo.masivo.domain.model;

import java.time.LocalDateTime;

public class ResultadoCotejo {
    private String resultadoId;
    private String registroEntradaId;
    private String ejecucionId;
    private String codigoResultado;
    private String numeroDniEncontrado;
    private String apellidoPaternoEncontrado;
    private String apellidoMaternoEncontrado;
    private String nombresEncontrado;
    private LocalDateTime fechaNacimientoEncontrada;
    private String indicadorSexoEncontrado;
    private String codigoUbigeoDomicilio;
    private String descripcionDomicilio;
    private String estadoCivil;
    private String condicionCiudadano;
    private LocalDateTime fechaCaducidadDni;
    private String indicadorRestriccion;
    private LocalDateTime fechaRestriccion;
    private String coincideDni;
    private String coincideApellidoPaterno;
    private String coincideApellidoMaterno;
    private String coincideNombres;
    private String coincideFechaNacimiento;
    private String coincideSexo;
    private String mensajeObservacion;

    public ResultadoCotejo() {
    }

    public ResultadoCotejo(String resultadoId, String registroEntradaId, String ejecucionId, String codigoResultado) {
        this.resultadoId = resultadoId;
        this.registroEntradaId = registroEntradaId;
        this.ejecucionId = ejecucionId;
        this.codigoResultado = codigoResultado;
    }

    public String getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(String resultadoId) {
        this.resultadoId = resultadoId;
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

    public String getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getNumeroDniEncontrado() {
        return numeroDniEncontrado;
    }

    public void setNumeroDniEncontrado(String numeroDniEncontrado) {
        this.numeroDniEncontrado = numeroDniEncontrado;
    }

    public String getApellidoPaternoEncontrado() {
        return apellidoPaternoEncontrado;
    }

    public void setApellidoPaternoEncontrado(String apellidoPaternoEncontrado) {
        this.apellidoPaternoEncontrado = apellidoPaternoEncontrado;
    }

    public String getApellidoMaternoEncontrado() {
        return apellidoMaternoEncontrado;
    }

    public void setApellidoMaternoEncontrado(String apellidoMaternoEncontrado) {
        this.apellidoMaternoEncontrado = apellidoMaternoEncontrado;
    }

    public String getNombresEncontrado() {
        return nombresEncontrado;
    }

    public void setNombresEncontrado(String nombresEncontrado) {
        this.nombresEncontrado = nombresEncontrado;
    }

    public LocalDateTime getFechaNacimientoEncontrada() {
        return fechaNacimientoEncontrada;
    }

    public void setFechaNacimientoEncontrada(LocalDateTime fechaNacimientoEncontrada) {
        this.fechaNacimientoEncontrada = fechaNacimientoEncontrada;
    }

    public String getIndicadorSexoEncontrado() {
        return indicadorSexoEncontrado;
    }

    public void setIndicadorSexoEncontrado(String indicadorSexoEncontrado) {
        this.indicadorSexoEncontrado = indicadorSexoEncontrado;
    }

    public String getCodigoUbigeoDomicilio() {
        return codigoUbigeoDomicilio;
    }

    public void setCodigoUbigeoDomicilio(String codigoUbigeoDomicilio) {
        this.codigoUbigeoDomicilio = codigoUbigeoDomicilio;
    }

    public String getDescripcionDomicilio() {
        return descripcionDomicilio;
    }

    public void setDescripcionDomicilio(String descripcionDomicilio) {
        this.descripcionDomicilio = descripcionDomicilio;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCondicionCiudadano() {
        return condicionCiudadano;
    }

    public void setCondicionCiudadano(String condicionCiudadano) {
        this.condicionCiudadano = condicionCiudadano;
    }

    public LocalDateTime getFechaCaducidadDni() {
        return fechaCaducidadDni;
    }

    public void setFechaCaducidadDni(LocalDateTime fechaCaducidadDni) {
        this.fechaCaducidadDni = fechaCaducidadDni;
    }

    public String getIndicadorRestriccion() {
        return indicadorRestriccion;
    }

    public void setIndicadorRestriccion(String indicadorRestriccion) {
        this.indicadorRestriccion = indicadorRestriccion;
    }

    public LocalDateTime getFechaRestriccion() {
        return fechaRestriccion;
    }

    public void setFechaRestriccion(LocalDateTime fechaRestriccion) {
        this.fechaRestriccion = fechaRestriccion;
    }

    public String getCoincideDni() {
        return coincideDni;
    }

    public void setCoincideDni(String coincideDni) {
        this.coincideDni = coincideDni;
    }

    public String getCoincideApellidoPaterno() {
        return coincideApellidoPaterno;
    }

    public void setCoincideApellidoPaterno(String coincideApellidoPaterno) {
        this.coincideApellidoPaterno = coincideApellidoPaterno;
    }

    public String getCoincideApellidoMaterno() {
        return coincideApellidoMaterno;
    }

    public void setCoincideApellidoMaterno(String coincideApellidoMaterno) {
        this.coincideApellidoMaterno = coincideApellidoMaterno;
    }

    public String getCoincideNombres() {
        return coincideNombres;
    }

    public void setCoincideNombres(String coincideNombres) {
        this.coincideNombres = coincideNombres;
    }

    public String getCoincideFechaNacimiento() {
        return coincideFechaNacimiento;
    }

    public void setCoincideFechaNacimiento(String coincideFechaNacimiento) {
        this.coincideFechaNacimiento = coincideFechaNacimiento;
    }

    public String getCoincideSexo() {
        return coincideSexo;
    }

    public void setCoincideSexo(String coincideSexo) {
        this.coincideSexo = coincideSexo;
    }

    public String getMensajeObservacion() {
        return mensajeObservacion;
    }

    public void setMensajeObservacion(String mensajeObservacion) {
        this.mensajeObservacion = mensajeObservacion;
    }
}
