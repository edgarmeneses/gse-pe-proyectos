package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Información de Auditoría
 */
public class AuditoriaDto {

    private String usuarioCrea;
    private String usuarioModifica;
    private String oficinaCrea;

    public AuditoriaDto() {
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public String getOficinaCrea() {
        return oficinaCrea;
    }

    public void setOficinaCrea(String oficinaCrea) {
        this.oficinaCrea = oficinaCrea;
    }
}
