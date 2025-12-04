package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class InformacionPublicacionDto {
    private String fechaPublicacion;
    private String lugarPublicacion;
    private String observaciones;

    public InformacionPublicacionDto() {
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getLugarPublicacion() {
        return lugarPublicacion;
    }

    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
