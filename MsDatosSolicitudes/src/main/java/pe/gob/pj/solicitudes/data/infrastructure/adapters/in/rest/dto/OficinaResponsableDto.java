package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class OficinaResponsableDto {
    private final String codigo;
    private final String nombre;

    public OficinaResponsableDto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String codigo() { return codigo; }
    public String nombre() { return nombre; }
}
