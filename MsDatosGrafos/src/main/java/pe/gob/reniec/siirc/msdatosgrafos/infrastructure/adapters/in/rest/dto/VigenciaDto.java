package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class VigenciaDto {
    private String fechaInicio;
    private String fechaFin;
    private Boolean esVigente;

    public VigenciaDto() {
    }

    public VigenciaDto(String fechaInicio, String fechaFin, Boolean esVigente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esVigente = esVigente;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}
