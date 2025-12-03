package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class ResumenEventosDto {
    private final Long totalCambiosEstado;
    private final Long totalModificaciones;
    private final Long totalAsignaciones;
    private final Long totalDiligencias;
    private final Long totalValidaciones;
    private final Long totalComentarios;
    private final Long totalNotificaciones;

    public ResumenEventosDto(Long totalCambiosEstado, Long totalModificaciones, Long totalAsignaciones, Long totalDiligencias, Long totalValidaciones, Long totalComentarios, Long totalNotificaciones) {
        this.totalCambiosEstado = totalCambiosEstado;
        this.totalModificaciones = totalModificaciones;
        this.totalAsignaciones = totalAsignaciones;
        this.totalDiligencias = totalDiligencias;
        this.totalValidaciones = totalValidaciones;
        this.totalComentarios = totalComentarios;
        this.totalNotificaciones = totalNotificaciones;
    }

    public Long totalCambiosEstado() { return totalCambiosEstado; }
    public Long totalModificaciones() { return totalModificaciones; }
    public Long totalAsignaciones() { return totalAsignaciones; }
    public Long totalDiligencias() { return totalDiligencias; }
    public Long totalValidaciones() { return totalValidaciones; }
    public Long totalComentarios() { return totalComentarios; }
    public Long totalNotificaciones() { return totalNotificaciones; }
}
