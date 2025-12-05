package pe.gse.adaptadorbcp.domain.model;

public class EntidadPlaceholder {
    private Long id;
    private String descripcion;

    public EntidadPlaceholder() {}

    public EntidadPlaceholder(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
