package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record DatosContactoEntidadDto(
        String nombre,
        String direccion,
        String email,
        String telefono
) {
}
