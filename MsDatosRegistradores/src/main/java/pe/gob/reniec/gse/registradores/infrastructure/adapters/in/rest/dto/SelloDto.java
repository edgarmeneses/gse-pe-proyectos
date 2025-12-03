package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Sello
 */
public class SelloDto {
    private Boolean tieneRegistrado;
    private String hashSello;
    private String fechaUltimaActualizacion;

    public SelloDto() {
    }

    public SelloDto(Boolean tieneRegistrado, String hashSello, String fechaUltimaActualizacion) {
        this.tieneRegistrado = tieneRegistrado;
        this.hashSello = hashSello;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Boolean getTieneRegistrado() {
        return tieneRegistrado;
    }

    public void setTieneRegistrado(Boolean tieneRegistrado) {
        this.tieneRegistrado = tieneRegistrado;
    }

    public String getHashSello() {
        return hashSello;
    }

    public void setHashSello(String hashSello) {
        this.hashSello = hashSello;
    }

    public String getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
}
