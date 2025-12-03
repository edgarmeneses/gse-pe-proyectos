package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class UsuarioDto {
    private final String usuarioId;
    private final String nombreCompleto;
    private final String rol;
    private final String email;

    public UsuarioDto(String usuarioId, String nombreCompleto, String rol, String email) {
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.email = email;
    }

    public String usuarioId() { return usuarioId; }
    public String nombreCompleto() { return nombreCompleto; }
    public String rol() { return rol; }
    public String email() { return email; }
}
