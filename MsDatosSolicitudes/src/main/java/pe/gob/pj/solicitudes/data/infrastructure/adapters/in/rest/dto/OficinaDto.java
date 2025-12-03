package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class OficinaDto {
    private final String codigo;
    private final String nombre;

    public OficinaDto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String codigo() { return codigo; }
    public String nombre() { return nombre; }
}
