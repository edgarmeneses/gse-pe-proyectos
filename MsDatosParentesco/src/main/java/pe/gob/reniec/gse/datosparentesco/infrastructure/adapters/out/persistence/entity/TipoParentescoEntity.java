package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence.entity;

public class TipoParentescoEntity {
    private String codigo;
    private String descripcion;
    private String tipoInverso;

    public TipoParentescoEntity() {
    }

    public TipoParentescoEntity(String codigo, String descripcion, String tipoInverso) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoInverso = tipoInverso;
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

    public String getTipoInverso() {
        return tipoInverso;
    }

    public void setTipoInverso(String tipoInverso) {
        this.tipoInverso = tipoInverso;
    }
}
