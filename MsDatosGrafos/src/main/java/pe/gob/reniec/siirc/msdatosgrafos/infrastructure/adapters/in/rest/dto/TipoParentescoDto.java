package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class TipoParentescoDto {
    private String codigo;
    private String descripcion;
    private Boolean esSimetrico;

    public TipoParentescoDto() {
    }

    public TipoParentescoDto(String codigo, String descripcion, Boolean esSimetrico) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.esSimetrico = esSimetrico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsSimetrico() {
        return esSimetrico;
    }

    public void setEsSimetrico(Boolean esSimetrico) {
        this.esSimetrico = esSimetrico;
    }
}
