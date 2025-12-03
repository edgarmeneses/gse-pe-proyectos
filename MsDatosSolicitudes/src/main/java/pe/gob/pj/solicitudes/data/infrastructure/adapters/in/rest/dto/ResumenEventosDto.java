package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record ResumenEventosDto(
        Long totalCambiosEstado,
        Long totalModificaciones,
        Long totalAsignaciones,
        Long totalDiligencias,
        Long totalValidaciones,
        Long totalComentarios,
        Long totalNotificaciones
) {
}
