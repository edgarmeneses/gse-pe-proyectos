package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record DireccionDto(
        String departamento,
        String provincia,
        String distrito,
        String direccionCompleta
) {
}
