package pe.gob.reniec.circunscripciones.domain.model;

import java.time.LocalDateTime;

public class MigracionDomiciliaria {

    private String migracionId;
    private String dni;
    private String nombreCompleto;
    private Domicilio domicilioAnterior;
    private Domicilio domicilioNuevo;
    private LocalDateTime fechaCambio;
    private String tipoMovimiento;
    private String estadoVerificacion;
    private Boolean tieneAlertaRAE;
    private CircunscripcionElectoral circunscripcionElectoral;

    public MigracionDomiciliaria() {
    }

    public MigracionDomiciliaria(String migracionId, String dni, String nombreCompleto,
                                 Domicilio domicilioAnterior, Domicilio domicilioNuevo,
                                 LocalDateTime fechaCambio, String tipoMovimiento,
                                 String estadoVerificacion, Boolean tieneAlertaRAE,
                                 CircunscripcionElectoral circunscripcionElectoral) {
        this.migracionId = migracionId;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.domicilioAnterior = domicilioAnterior;
        this.domicilioNuevo = domicilioNuevo;
        this.fechaCambio = fechaCambio;
        this.tipoMovimiento = tipoMovimiento;
        this.estadoVerificacion = estadoVerificacion;
        this.tieneAlertaRAE = tieneAlertaRAE;
        this.circunscripcionElectoral = circunscripcionElectoral;
    }

    public String getMigracionId() {
        return migracionId;
    }

    public void setMigracionId(String migracionId) {
        this.migracionId = migracionId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Domicilio getDomicilioAnterior() {
        return domicilioAnterior;
    }

    public void setDomicilioAnterior(Domicilio domicilioAnterior) {
        this.domicilioAnterior = domicilioAnterior;
    }

    public Domicilio getDomicilioNuevo() {
        return domicilioNuevo;
    }

    public void setDomicilioNuevo(Domicilio domicilioNuevo) {
        this.domicilioNuevo = domicilioNuevo;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getEstadoVerificacion() {
        return estadoVerificacion;
    }

    public void setEstadoVerificacion(String estadoVerificacion) {
        this.estadoVerificacion = estadoVerificacion;
    }

    public Boolean getTieneAlertaRAE() {
        return tieneAlertaRAE;
    }

    public void setTieneAlertaRAE(Boolean tieneAlertaRAE) {
        this.tieneAlertaRAE = tieneAlertaRAE;
    }

    public CircunscripcionElectoral getCircunscripcionElectoral() {
        return circunscripcionElectoral;
    }

    public void setCircunscripcionElectoral(CircunscripcionElectoral circunscripcionElectoral) {
        this.circunscripcionElectoral = circunscripcionElectoral;
    }
}
