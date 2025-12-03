package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record UsuarioDto(
        String usuarioId,
        String nombreCompleto,
        String rol,
        String email
) {
}
