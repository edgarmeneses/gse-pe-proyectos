package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class AprobarPaqueteRequestDto {
    private InformacionPublicacionDto informacionPublicacion;
    private String comentarioAprobacion;
    private Boolean confirmarIntegridad;

    public AprobarPaqueteRequestDto() {
    }

    public InformacionPublicacionDto getInformacionPublicacion() {
        return informacionPublicacion;
    }

    public void setInformacionPublicacion(InformacionPublicacionDto informacionPublicacion) {
        this.informacionPublicacion = informacionPublicacion;
    }

    public String getComentarioAprobacion() {
        return comentarioAprobacion;
    }

    public void setComentarioAprobacion(String comentarioAprobacion) {
        this.comentarioAprobacion = comentarioAprobacion;
    }

    public Boolean getConfirmarIntegridad() {
        return confirmarIntegridad;
    }

    public void setConfirmarIntegridad(Boolean confirmarIntegridad) {
        this.confirmarIntegridad = confirmarIntegridad;
    }
}
