package pe.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto;

public class EntidadResponseDto {
    private Long id;
    private String contenido;

    public EntidadResponseDto() {}

    public EntidadResponseDto(Long id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
