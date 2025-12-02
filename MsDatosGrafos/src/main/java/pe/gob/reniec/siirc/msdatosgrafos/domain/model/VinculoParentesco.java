package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Aggregate Root que representa un vínculo de parentesco entre dos ciudadanos
 */
public class VinculoParentesco {
    private final Long idRelacion;
    private final TipoParentesco tipoParentesco;
    private final Long gradoParentesco;
    private final String categoriaParentesco;
    private final Ciudadano ciudadanoRelacionado;
    private final Vigencia vigencia;
    private final Sustento sustento;
    private final String observacion;

    public VinculoParentesco(Long idRelacion, TipoParentesco tipoParentesco, Long gradoParentesco,
                             String categoriaParentesco, Ciudadano ciudadanoRelacionado,
                             Vigencia vigencia, Sustento sustento, String observacion) {
        this.idRelacion = idRelacion;
        this.tipoParentesco = tipoParentesco;
        this.gradoParentesco = gradoParentesco;
        this.categoriaParentesco = categoriaParentesco;
        this.ciudadanoRelacionado = ciudadanoRelacionado;
        this.vigencia = vigencia;
        this.sustento = sustento;
        this.observacion = observacion;
    }

    public Long getIdRelacion() {
        return idRelacion;
    }

    public TipoParentesco getTipoParentesco() {
        return tipoParentesco;
    }

    public Long getGradoParentesco() {
        return gradoParentesco;
    }

    public String getCategoriaParentesco() {
        return categoriaParentesco;
    }

    public Ciudadano getCiudadanoRelacionado() {
        return ciudadanoRelacionado;
    }

    public Vigencia getVigencia() {
        return vigencia;
    }

    public Sustento getSustento() {
        return sustento;
    }

    public String getObservacion() {
        return observacion;
    }
}
