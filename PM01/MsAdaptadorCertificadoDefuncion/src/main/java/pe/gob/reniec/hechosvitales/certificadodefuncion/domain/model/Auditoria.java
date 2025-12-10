package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model;

/**
 * Value Object: Información de Auditoría
 */
public class Auditoria {

    private String usuarioCrea;
    private String usuarioModifica;
    private String oficinaCrea;

    public Auditoria() {
    }

    public Auditoria(String usuarioCrea, String usuarioModifica, String oficinaCrea) {
        this.usuarioCrea = usuarioCrea;
        this.usuarioModifica = usuarioModifica;
        this.oficinaCrea = oficinaCrea;
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
