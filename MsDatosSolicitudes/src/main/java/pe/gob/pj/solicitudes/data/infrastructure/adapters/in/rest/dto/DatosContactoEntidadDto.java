package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class DatosContactoEntidadDto {
    private final String nombre;
    private final String direccion;
    private final String email;
    private final String telefono;

    public DatosContactoEntidadDto(String nombre, String direccion, String email, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public String nombre() { return nombre; }
    public String direccion() { return direccion; }
    public String email() { return email; }
    public String telefono() { return telefono; }
}
