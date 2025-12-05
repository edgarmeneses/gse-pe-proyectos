package pe.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto;

public class EntidadRequestDto {
    // Estructura no especificada en el PDF
    private String contenido;

    public EntidadRequestDto() {}

    public EntidadRequestDto(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
