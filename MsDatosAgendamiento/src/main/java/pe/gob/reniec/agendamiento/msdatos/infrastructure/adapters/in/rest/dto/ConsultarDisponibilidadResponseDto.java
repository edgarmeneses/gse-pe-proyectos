package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultarDisponibilidadResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata
) {
    public record DataDto(
        SedeServicioDto sedeServicio,
        RangoConsultadoDto rangoConsultado,
        List<DisponibilidadDiaDto> disponibilidad,
        ResumenDto resumen
    ) {}

    public record SedeServicioDto(
        String codigoSede,
        String nombreSede,
        String direccion,
        Integer tiempoAtencionMinutos
    ) {}

    public record RangoConsultadoDto(
        String fechaDesde,
        String fechaHasta
    ) {}

    public record DisponibilidadDiaDto(
        String fecha,
        String diaSemana,
        Boolean esHabil,
        String motivoNoHabil,
        List<FranjaDto> franjas
    ) {}

    public record FranjaDto(
        String idDisponibilidad,
        String horaInicio,
        String horaFin,
        Integer capacidadTotal,
        Integer capacidadOcupada,
        Integer capacidadDisponible,
        String estado
    ) {}

    public record ResumenDto(
        Integer totalDias,
        Integer diasHabiles,
        Integer diasNoHabiles,
        Integer totalFranjas,
        Integer franjasDisponibles,
        Integer franjasOcupadas
    ) {}

    public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
    ) {}
}
