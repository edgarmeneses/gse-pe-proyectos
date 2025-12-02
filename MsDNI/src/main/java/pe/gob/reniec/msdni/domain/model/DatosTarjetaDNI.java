package pe.gob.reniec.msdni.domain.model;

import java.time.LocalDate;

public class DatosTarjetaDNI {
    private LocalDate fechaEmisionDni;
    private LocalDate fechaCaducidadDni;
    private Long versionDni;
    private String numeroTarjeta;

    public DatosTarjetaDNI() {
    }

    public DatosTarjetaDNI(LocalDate fechaEmisionDni, LocalDate fechaCaducidadDni,
                           Long versionDni, String numeroTarjeta) {
        this.fechaEmisionDni = fechaEmisionDni;
        this.fechaCaducidadDni = fechaCaducidadDni;
        this.versionDni = versionDni;
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaEmisionDni() {
        return fechaEmisionDni;
    }

    public void setFechaEmisionDni(LocalDate fechaEmisionDni) {
        this.fechaEmisionDni = fechaEmisionDni;
    }

    public LocalDate getFechaCaducidadDni() {
        return fechaCaducidadDni;
    }

    public void setFechaCaducidadDni(LocalDate fechaCaducidadDni) {
        this.fechaCaducidadDni = fechaCaducidadDni;
    }

    public Long getVersionDni() {
        return versionDni;
    }

    public void setVersionDni(Long versionDni) {
        this.versionDni = versionDni;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
