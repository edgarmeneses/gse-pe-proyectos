package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class VinculoDto {
    private Long idRelacion;
    private TipoParentescoDto tipoParentesco;
    private Integer gradoParentesco;
    private String categoriaParentesco;
    private CiudadanoDto ciudadanoRelacionado;
    private VigenciaDto vigencia;
    private SustentoDto sustento;
    private String observacion;

    public VinculoDto() {
    }

    public VinculoDto(Long idRelacion, TipoParentescoDto tipoParentesco, Integer gradoParentesco,
                      String categoriaParentesco, CiudadanoDto ciudadanoRelacionado,
                      VigenciaDto vigencia, SustentoDto sustento, String observacion) {
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

    public TipoParentescoDto getTipoParentesco() {
        return tipoParentesco;
    }

    public void setTipoParentesco(TipoParentescoDto tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }

    public Integer getGradoParentesco() {
        return gradoParentesco;
    }

    public void setGradoParentesco(Integer gradoParentesco) {
        this.gradoParentesco = gradoParentesco;
    }

    public String getCategoriaParentesco() {
        return categoriaParentesco;
    }

    public void setCategoriaParentesco(String categoriaParentesco) {
        this.categoriaParentesco = categoriaParentesco;
    }

    public CiudadanoDto getCiudadanoRelacionado() {
        return ciudadanoRelacionado;
    }

    public void setCiudadanoRelacionado(CiudadanoDto ciudadanoRelacionado) {
        this.ciudadanoRelacionado = ciudadanoRelacionado;
    }

    public VigenciaDto getVigencia() {
        return vigencia;
    }

    public void setVigencia(VigenciaDto vigencia) {
        this.vigencia = vigencia;
    }

    public SustentoDto getSustento() {
        return sustento;
    }

    public void setSustento(SustentoDto sustento) {
        this.sustento = sustento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
