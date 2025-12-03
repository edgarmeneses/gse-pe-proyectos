package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Firma
 */
public class FirmaDto {
    private Boolean tieneRegistrada;
    private String hashFirma;
    private String fechaUltimaActualizacion;

    public FirmaDto() {
    }

    public FirmaDto(Boolean tieneRegistrada, String hashFirma, String fechaUltimaActualizacion) {
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

    public String getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
}
