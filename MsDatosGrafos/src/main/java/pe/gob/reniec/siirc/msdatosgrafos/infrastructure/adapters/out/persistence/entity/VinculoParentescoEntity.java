package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

/**
 * Entity para persistencia de Vínculo de Parentesco
 * POJO sin anotaciones de framework
 * Representa un registro en la tabla GRF_PARENTESCO de la base de datos de grafos
 */
public class VinculoParentescoEntity {
    private Long idRelacion;
    private TipoParentescoEntity tipoParentesco;
    private Long gradoParentesco;
    private String categoriaParentesco;
    private CiudadanoEntity ciudadanoRelacionado;
    private VigenciaEntity vigencia;
    private SustentoEntity sustento;
    private String observacion;

    public VinculoParentescoEntity() {
    }

    public VinculoParentescoEntity(Long idRelacion, TipoParentescoEntity tipoParentesco, 
                                   Long gradoParentesco, String categoriaParentesco,
                                   CiudadanoEntity ciudadanoRelacionado, VigenciaEntity vigencia, 
                                   SustentoEntity sustento, String observacion) {
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

    public void setIdRelacion(Long idRelacion) {
        this.idRelacion = idRelacion;
    }

    public TipoParentescoEntity getTipoParentesco() {
        return tipoParentesco;
    }

    public void setTipoParentesco(TipoParentescoEntity tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }

    public Long getGradoParentesco() {
        return gradoParentesco;
    }

    public void setGradoParentesco(Long gradoParentesco) {
        this.gradoParentesco = gradoParentesco;
    }

    public String getCategoriaParentesco() {
        return categoriaParentesco;
    }

    public void setCategoriaParentesco(String categoriaParentesco) {
        this.categoriaParentesco = categoriaParentesco;
    }

    public CiudadanoEntity getCiudadanoRelacionado() {
        return ciudadanoRelacionado;
    }

    public void setCiudadanoRelacionado(CiudadanoEntity ciudadanoRelacionado) {
        this.ciudadanoRelacionado = ciudadanoRelacionado;
    }

    public VigenciaEntity getVigencia() {
        return vigencia;
    }

    public void setVigencia(VigenciaEntity vigencia) {
        this.vigencia = vigencia;
    }

    public SustentoEntity getSustento() {
        return sustento;
    }

    public void setSustento(SustentoEntity sustento) {
        this.sustento = sustento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
