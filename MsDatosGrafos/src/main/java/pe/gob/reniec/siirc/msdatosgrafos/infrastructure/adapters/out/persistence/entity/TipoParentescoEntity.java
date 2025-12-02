package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;

/**
 * Entity para persistencia de Tipo de Parentesco
 * POJO sin anotaciones de framework
 */
public class TipoParentescoEntity {
    private String codigo;
    private String descripcion;
    private Boolean esSimetrico;

    public TipoParentescoEntity() {
    }

    public TipoParentescoEntity(String codigo, String descripcion, Boolean esSimetrico) {
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
