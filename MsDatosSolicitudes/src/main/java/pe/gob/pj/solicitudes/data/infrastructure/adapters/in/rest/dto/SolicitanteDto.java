package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class SolicitanteDto {
    private final String dni;
    private final String nombres;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final String email;
    private final String telefono;
    private final DireccionDto direccion;

    public SolicitanteDto(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, String email, String telefono, DireccionDto direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String dni() { return dni; }
    public String nombres() { return nombres; }
    public String apellidoPaterno() { return apellidoPaterno; }
    public String apellidoMaterno() { return apellidoMaterno; }
    public String email() { return email; }
    public String telefono() { return telefono; }
    public DireccionDto direccion() { return direccion; }
}
