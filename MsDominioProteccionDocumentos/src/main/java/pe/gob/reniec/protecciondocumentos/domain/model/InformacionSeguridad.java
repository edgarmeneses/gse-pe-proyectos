package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;

public class InformacionSeguridad {
    private String passwordHashSHA512;
    private String algoritmoUtilizado;
    private Integer longitudPassword;
    private LocalDateTime fechaGeneracion;
    private LocalDateTime fechaExpiracion;

    public InformacionSeguridad() {
    }

    public InformacionSeguridad(String passwordHashSHA512, String algoritmoUtilizado, Integer longitudPassword, 
                               LocalDateTime fechaGeneracion, LocalDateTime fechaExpiracion) {
        this.passwordHashSHA512 = passwordHashSHA512;
        this.algoritmoUtilizado = algoritmoUtilizado;
        this.longitudPassword = longitudPassword;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getPasswordHashSHA512() {
        return passwordHashSHA512;
    }

    public void setPasswordHashSHA512(String passwordHashSHA512) {
        this.passwordHashSHA512 = passwordHashSHA512;
    }

    public String getAlgoritmoUtilizado() {
        return algoritmoUtilizado;
    }

    public void setAlgoritmoUtilizado(String algoritmoUtilizado) {
        this.algoritmoUtilizado = algoritmoUtilizado;
    }

    public Integer getLongitudPassword() {
        return longitudPassword;
    }

    public void setLongitudPassword(Integer longitudPassword) {
        this.longitudPassword = longitudPassword;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
