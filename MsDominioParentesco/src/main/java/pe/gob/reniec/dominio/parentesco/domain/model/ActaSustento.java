package pe.gob.reniec.dominio.parentesco.domain.model;

import java.time.LocalDate;

public class ActaSustento {
    private String tipoActa;
    private String numeroActa;
    private LocalDate fechaRegistro;
    private String oficinaRegistral;

    public ActaSustento() {
    }

    public ActaSustento(String tipoActa, String numeroActa, LocalDate fechaRegistro,
                       String oficinaRegistral) {
        this.tipoActa = tipoActa;
        this.numeroActa = numeroActa;
        this.fechaRegistro = fechaRegistro;
        this.oficinaRegistral = oficinaRegistral;
    }

    public String getTipoActa() {
        return tipoActa;
    }

    public void setTipoActa(String tipoActa) {
        this.tipoActa = tipoActa;
    }

    public String getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(String numeroActa) {
        this.numeroActa = numeroActa;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(String oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }
}
