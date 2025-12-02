package pe.gob.reniec.msdatosregistradores.domain.model;

import java.time.LocalDateTime;

public class Firma {
    private Boolean tieneRegistrada;
    private String hashFirma;
    private LocalDateTime fechaUltimaActualizacion;

    public Firma() {
    }

    public Firma(Boolean tieneRegistrada, String hashFirma, LocalDateTime fechaUltimaActualizacion) {
        this.tieneRegistrada = tieneRegistrada;
        this.hashFirma = hashFirma;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Boolean getTieneRegistrada() {
        return tieneRegistrada;
    }

    public void setTieneRegistrada(Boolean tieneRegistrada) {
        this.tieneRegistrada = tieneRegistrada;
    }

    public String getHashFirma() {
        return hashFirma;
    }

    public void setHashFirma(String hashFirma) {
        this.hashFirma = hashFirma;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
}
