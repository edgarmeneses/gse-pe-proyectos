package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Aggregate Root que representa una relación de parentesco entre dos ciudadanos.
 * Encapsula las reglas de negocio sobre vínculos familiares.
 */
public class VinculoParentesco {
    private final Long idRelacion;
    private final TipoParentesco tipoParentesco;
    private final Integer gradoParentesco;
    private final CategoriaParentesco categoriaParentesco;
    private final Ciudadano ciudadanoRelacionado;
    private final Vigencia vigencia;
    private final Sustento sustento;
    private final String observacion;

    public VinculoParentesco(Long idRelacion, TipoParentesco tipoParentesco, 
                            Integer gradoParentesco, CategoriaParentesco categoriaParentesco, 
                            Ciudadano ciudadanoRelacionado, Vigencia vigencia, 
                            Sustento sustento, String observacion) {
        if (tipoParentesco == null) {
            throw new IllegalArgumentException("El tipo de parentesco es obligatorio");
        }
        if (ciudadanoRelacionado == null) {
            throw new IllegalArgumentException("El ciudadano relacionado es obligatorio");
        }
        if (gradoParentesco != null && gradoParentesco < 0) {
            throw new IllegalArgumentException("El grado de parentesco no puede ser negativo");
        }
        
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

    public Integer getGradoParentesco() {
        return gradoParentesco;
    }

    public CategoriaParentesco getCategoriaParentesco() {
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

    /**
     * Verifica si el vínculo es de una categoría específica.
     */
    public boolean esDeCategoria(CategoriaParentesco categoria) {
        return this.categoriaParentesco == categoria;
    }

    /**
     * Verifica si el vínculo está vigente actualmente.
     */
    public boolean esVigente() {
        return vigencia != null && vigencia.estaVigente();
    }

    /**
     * Verifica si el vínculo tiene sustento documental.
     */
    public boolean tieneSustento() {
        return sustento != null && sustento.tieneDocumentos();
    }
}
