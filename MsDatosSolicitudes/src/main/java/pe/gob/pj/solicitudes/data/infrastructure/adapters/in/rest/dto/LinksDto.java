package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record LinksDto(
        String self,
        String actualizar,
        String cambiarEstado,
        String historial
) {
}
